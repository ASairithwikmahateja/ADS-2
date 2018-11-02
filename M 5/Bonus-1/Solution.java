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
     * The time complexity is O(V + E).
     *
     * @param      args  The arguments
     */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp = sc.nextLine();
		String[] inputs = inp.split(" ");
		int v = Integer.parseInt(inputs[0]);
		int e = Integer.parseInt(inputs[1]);
		if (e == 0) {
			System.out.println(e);
		} else {
			Graph gph = new Graph(v + 1);
			while (sc.hasNext()) {
			String connect = sc.nextLine();
			String[] connects = connect.split(" ");
			gph.addEdge(Integer.parseInt(connects[0]),
                Integer.parseInt(connects[1]));
        }
        CC connected = new CC(gph);
        int parallelcount = 0;
        int maxcount = 0;
        int id = 0;
        int[] idar = connected.idarray();
        for (int i = 0; i < gph.vertices(); i++) {
        	if (gph.hasParallelEdges(i)) {
        		parallelcount++;
        	}
        	int idcount = 0;
        	id = idar[i];
        	for (int j = 0; j < idar.length; j++) {
        		if (id == idar[j]) {
        			idcount++;
        		}
        	}
        	if (maxcount < idcount) {
        	    maxcount = idcount;
        	}
        }
        System.out.println(parallelcount + maxcount);
		}
	}
}

