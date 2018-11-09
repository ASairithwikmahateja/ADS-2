import java.lang.Math.*;

public class SeamCarver {
	// create a seam carver object based on the given picture
	Picture picture;
	public SeamCarver(Picture picturee) {
		this.picture = picturee;
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
	int rx = picture.get(x, y - 1).getRed() - picture.get(x, y + 1).getRed();
	int gx = picture.get(x, y - 1).getGreen() - picture.get(x, y + 1).getGreen();
	int bx = picture.get(x, y - 1).getBlue() - picture.get(x, y + 1).getBlue();
	double xs = (rx * rx) + (gx * gx) + (bx * bx);
	int ry = picture.get(x - 1, y).getRed() - picture.get(x + 1, y).getRed();
	int gy = picture.get(x - 1, y).getGreen() - picture.get(x + 1, y).getGreen();
	int by = picture.get(x - 1, y).getBlue() - picture.get(x + 1, y).getBlue();
	double ys = (ry * ry) + (gy * gy) + (by * by);
	double result = Math.sqrt(xs + ys);
	return result;
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}
