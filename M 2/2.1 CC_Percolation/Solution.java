import java.util.Scanner;
/**
 * class Solution.
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
		while (sc.hasNextLine()) {
			String[] str = sc.nextLine().split(" ");
			Newgraph g = new Newgraph(n);
			g.addEdge(Integer.parseInt(str[0]),
				Integer.parseInt(str[1]));
			CC c = new CC(g);
			System.out.println(c.areConnected(Integer.parseInt(str[0]),
				Integer.parseInt(str[1])));
			}
	}
}