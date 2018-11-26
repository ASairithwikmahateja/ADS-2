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
     * The time complexity is O(N).
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int nvert = Integer.parseInt(sc.nextLine());
        int nedge = Integer.parseInt(sc.nextLine());
        Digraph d = new Digraph(nvert);
        for (int i = 0; i < nedge; i++) {
            String[] str = sc.nextLine().split(" ");
            d.addEdge(Integer.parseInt(str[0]),
                Integer.parseInt(str[1]));
        }
        DirectedCycle cyc = new DirectedCycle(d);
        if (cyc.hasCycle()) {
            System.out.println("Cycle exists.");
        } else {
            System.out.println("Cycle doesn't exists.");
        }
    }
}

