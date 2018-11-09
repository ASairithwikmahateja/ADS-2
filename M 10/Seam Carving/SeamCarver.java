import java.lang.Math.*;

public class SeamCarver {
	// create a seam carver object based on the given picture
	private Picture picture;
	private double[] energy;
	private int[] pathTo;
	
	public SeamCarver(Picture picturee) {
		this.picture = picturee;
		if (picture == null) {
			System.out.println("picture is null");
			return;
		}
	}
	// current picture
	public Picture picture() {
		return picture;
	}
	// width of current picture
	public int width() {
		return picture.width();
	}

	// height of current picture
	public int height() {
		return picture.height();
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		if (x == 0 || x == picture.width() - 1) {
			return 1000;
		} else if (y == 0 || y == picture.height() - 1) {
			return 1000;
		}
	//x coordinate red, blue, green
	int rX = picture.get(x, y - 1).getRed() - picture.get(x, y + 1).getRed();
	int gX = picture.get(x, y - 1).getGreen() - picture.get(x, y + 1).getGreen();
	int bX = picture.get(x, y - 1).getBlue() - picture.get(x, y + 1).getBlue();
	double xS = (rX * rX) + (gX * gX) + (bX * bX);
	//y coordinate red, blue, green
	int rY = picture.get(x - 1, y).getRed() - picture.get(x + 1, y).getRed();
	int gY = picture.get(x - 1, y).getGreen() - picture.get(x + 1, y).getGreen();
	int bY = picture.get(x - 1, y).getBlue() - picture.get(x + 1, y).getBlue();
	double yS = (rY * rY) + (gY * gY) + (bY * bY);
	double result = Math.sqrt(xS + yS);
	return result;
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		int w = height(), h = width();
		computeEnergy(w, h, 1);
		return computePath(w, h);
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		int w = width(), h = height();
		computeEnergy(w, h, 0);
		return computePath(w, h);
	}

	/**
	 * Calculates the energy.
	 *
	 * @param      w     int
	 * @param      h     int
	 * @param      flag  The flag
	 */
	private void computeEnergy(int w, int h, int flag) {
		energy = new double[w * h];
		for (int r = 0; r < h; r++) {
			for (int c = 0; c < w; c++) {
				energy[r * w + c] = energy(c, r, flag);
			}
		}
	}

	/**
	 * Calculates the path.
	 *
	 * @param      w     int
	 * @param      h     int
	 *
	 * @return     The path.
	 */
	private int[] computePath(int w, int h) {
		pathTo = new int[w * h];
		for (int i = 0; i < w; i++)
			pathTo[i] = -1;
		for (int r = 1, i = w; r < h; r++) {
			if (energy[i - w] <= energy[i - w + 1]) pathTo[i] = i - w;
			else pathTo[i] = i - w + 1;
			energy[i] += energy[pathTo[i]]; i++;
			for (int c = 1; c < w - 1; c++, i++) {
				if (energy[i - w - 1] <= energy[i - w]) {
					if (energy[i - w - 1] <= energy[i - w + 1]) pathTo[i] = i - w;
					else pathTo[i] = i - w + 1;
				} else {
					if (energy[i - w] <= energy[i - w + 1]) pathTo[i] = i - w;
					else pathTo[i] = i - w + 1;
				}
				energy[i] += energy[pathTo[i]];
			}
			if (energy[i - w - 1] <= energy[i - w]) pathTo[i] = i - w - 1;
			else pathTo[i] = i - w;
			energy[i] += energy[pathTo[i]]; i++;
		}

		int pathEnd = w * (h - 1);
		double minE = energy[w * (h - 1)];
		for (int i = w * (h - 1); i < w * h; i++) {
			if (minE > energy[i]) {
				minE = energy[i];
				pathEnd = i;
			}
		}

		int[] path = new int[h];
		for (int p = pathEnd; p >= 0; p = pathTo[p])
			path[p / w] = p % w;
		return path;
	}

	/**
	 * energy method.
	 *
	 * @param      x     int
	 * @param      y     int
	 * @param      flag  The flag
	 *
	 * @return     double
	 */
	private double energy(int x, int y, int flag) {
		if (flag == 1)
			return energy(y, x);
		else
			return energy(x, y);
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {
		Picture p = new Picture(width(), height() - 1);
		int prerow = seam[0];
		for (int c = 0; c < width(); c++) {
			if (Math.abs(seam[c] - prerow) > 1)
				throw new IllegalArgumentException("Non-valid seam");
			if (seam[c] < 0 || seam[c] >= height())
				throw new IndexOutOfBoundsException();
			prerow = seam[c];
			for (int r = 0; r < height() - 1; r++)
				if (r < seam[c])
					p.set(c, r, picture.get(c, r));
				else
					p.set(c, r, picture.get(c, r + 1));
		}
		picture = p;
		energy = null;
		pathTo = null;
	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {
		Picture p = new Picture(width() - 1, height());
		int precol = seam[0];
		for (int r = 0; r < height(); r++) {
			if (Math.abs(seam[r] - precol) > 1)
				throw new IllegalArgumentException("Non-valid seam");
			if (seam[r] < 0 || seam[r] >= width())
				throw new IndexOutOfBoundsException();
			precol = seam[r];
			for (int c = 0; c < width() - 1; c++)
				if (c < seam[r])
					p.set(c, r, picture.get(c, r));
				else
					p.set(c, r, picture.get(c + 1, r));
		}
		picture = p;
		energy = null;
		pathTo = null;
	}
}
