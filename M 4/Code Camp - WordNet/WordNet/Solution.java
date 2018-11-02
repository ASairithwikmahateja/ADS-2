import java.util.Scanner;
/**
 * Class for solution.
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
		String sysfilnm = sc.nextLine();
		String hypfilnm = sc.nextLine();
		WordNet w = null;
		try {
		    w = new WordNet(sysfilnm, hypfilnm);
			} catch (Exception e) {
		    System.out.println(e);
		}
			// if (w.hasCycle) {
			// 	System.out.println("Cycle detected");
			// 	return ;
			// }
			String type = sc.nextLine();
			switch (type) {
			case("Graph"):
		 	    System.out.println(w.graph);
			break;
			case "Queries":
			while(sc.hasNextLine()) {
		 	    String[] tok = sc.nextLine().split(" ");
		 	    try {
		 	    w.sap(tok[0], tok[1]);
		 	    System.out.println("distance = " + w.sap(tok[0], tok[1]) +", ancestor =" + w.sap(tok[0], tok[1]));
		 	} catch (Exception e) {
		 		System.out.println("IllegalArgumentException");
		 	}
		 	break;
			}
		}
	}
}
