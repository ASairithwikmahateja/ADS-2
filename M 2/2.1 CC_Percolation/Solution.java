import java.util.Scanner;
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * matrix array of type boolean which stores the open and closed sites.
     */
    private boolean[][] matrix;
    /**
     * Virtual node top for top rows.
     */
    private int top = 0;
    /**
     * Virtual node bottom for bottom rows.
     */
    private int bottom;
    /**
     * size variable to keep track of the size of matrix.
     */
    private int size;
    /**
     * newgraph object.
     */
    private Newgraph g;
    /**
     * Constructs the object.
     * @param      n     number of nodes.
     */
    Percolation(final int n) {
        size = n;
        bottom = size * size + 1;
        g = new Newgraph(size * size + 2);
        matrix = new boolean[size][size];
    }
    /**
     * Open percolation.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    public Graph open(int v, int w) {
    	g.addEdge(v, w);
    	return g;
    }
    /**
     * Percolates method to find whether the matrix percolates or not.
     * @return     True if percolates, False otherwise.
     */
    public boolean percolates(CC c) {
        return c.connected(top, bottom);
    }
}
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
		Percolation p = new Percolation(n);
		String[] str = new String[2];
		while (sc.hasNext()) {
			str = sc.nextLine().split(" ");
			Graph temp = p.open(Integer.parseInt(str[0]),
				Integer.parseInt(str[1]));
			CC c = new CC(temp);
			System.out.println(p.percolates(c));
			
		}
	}
}
