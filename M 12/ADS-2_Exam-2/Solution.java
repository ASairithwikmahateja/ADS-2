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
		String caseToGo = sc.nextLine();
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
			System.out.println(ewg.toString());
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			String[] path = sc.nextLine().split(" ");
			DijkstrasSP d = new DijkstrasSP(ewg, Integer.parseInt(path[0]));
			if (d.hasPathTo(Integer.parseInt(path[1]))) {
				System.out.println(d.distTo(Integer.parseInt(path[1])));
			} else {
				System.out.println("No Path Found.");
			}
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			String[] pathe = sc.nextLine().split(" ");
			DijkstrasSP d1 = new DijkstrasSP(ewg, Integer.parseInt(pathe[0]));
			DijkstrasSP d2 = new DijkstrasSP(ewg, Integer.parseInt(pathe[1]));
			if (d1.hasPathTo(Integer.parseInt(pathe[1])) &&
				d2.hasPathTo(Integer.parseInt(pathe[2]))) {
				System.out.println(d1.distTo(Integer.parseInt(pathe[1])) +
					d2.distTo(Integer.parseInt(pathe[2])));
			String str = "";
			str = d1.pathTo(Integer.parseInt(pathe[1])).toString() + " " +
			d2.pathTo(Integer.parseInt(pathe[2])).toString();
			System.out.println(str);
			} else {
				System.out.println("No Path Found.");
			}
			break;

		default:
			break;
		}

	}
}