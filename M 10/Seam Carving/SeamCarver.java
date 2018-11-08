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
		double energy = 0.0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				energy = 1000.0;
			}
		}
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				energy = Math.sqrt(pixel(picture.get(i - 1, j), picture.get(i + 1, j)));
			// 	energyBlue = Math.pow((picture.getRed(i - 1, j) - picture.getRed(i + 1, j)), 2) 
			// 	+ Math.pow((picture.getRed(i, j - 1) - picture.getRed(i, j + 1)), 2);
			// 	energyGreen = Math.pow((picture.getRed(i - 1, j) - picture.getRed(i + 1, j)), 2)
			// 	+ Math.pow((picture.getRed(i, j -1 ) - picture.getRed(i, j + 1)), 2);
			}
		}
		return energy;
	}

	public int pixel(java.awt.Color x, java.awt.Color y) {
		int eneR = x.getRed() - y.getRed();
		int eneB = x.getBlue() - y.getBlue();
		int eneG = x.getGreen() - y.getGreen();
		return (eneR * eneR) + (eneB * eneB) + (eneG * eneG);
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