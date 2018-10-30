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
		Newgraph g = new Newgraph(n);
		String[] str = new String[0];
		while (sc.hasNext()) {
			str = sc.nextLine().split(" ");
			g.addEdge(Integer.parseInt(str[0]),
				Integer.parseInt(str[1]));
			CC c = new CC(g);
			boolean flag = true;
			for (int i = 0; i < g.edges(); i++) {
				flag = c.connected(Integer.parseInt(str[0]),
			    	Integer.parseInt(str[1]));
			    System.out.println(flag);
			}
			if (flag == true) {
				System.out.println(true);
				break;
			} else {
				System.out.println(false);
				break;
			}
		}
	}
}