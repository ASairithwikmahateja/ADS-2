import java.util.Scanner;
/**
 * Class Solution.
 */
public final class Solution {
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
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int k = Integer.parseInt(sc.nextLine());
		Edge e;
		EdgeWeightedGraph ewg = new EdgeWeightedGraph(n);
		for (int i = 0; i < k; i++) {
			String[] tok = sc.nextLine().split(" ");
			e = new Edge(Integer.parseInt(tok[0]), Integer.parseInt(tok[1]),
				Integer.parseInt(tok[2]));
			ewg.addEdge(e);
		}
		System.out.println(ewg.toString());

		String caseToGo = null;
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}
}