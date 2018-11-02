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
		try {
		    WordNet w = new WordNet(sysfilnm, hypfilnm);	
			String type = sc.nextLine();
			switch (type) {
			case("Graph"):
		 	    System.out.println(w.graph);
			break;
			case "Queries":
			while(sc.hasNextLine()) {
		 	    String[] tok = sc.nextLine().split(" ");
		 	    w.sap(tok[0], tok[1]);
		 	    System.out.println("distance = " + w.sap(tok[0], tok[1]) +", ancestor =" + w.sap(tok[0], tok[1]));
		 	}
		 	break;
			}

        } catch (Exception e) {
		    System.out.println(e);
		 	
		} 
	}
}
