import java.util.Scanner;
/**
 * class Solution.
 * Time complexity for this method is O(N) since
 * we are using while loop.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * Main function.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Percolation p = new Percolation(n);
		String[] str = new String[2];
		while (sc.hasNext()) {
			p.open(Integer.parseInt(str[0]) - 1,
				Integer.parseInt(str[1]) + 1);
		} System.out.println(p.percolates());
	}
}
