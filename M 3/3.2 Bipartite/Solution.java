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
        int nvert = Integer.parseInt(sc.nextLine());
        int nedge = Integer.parseInt(sc.nextLine());
        Newgraph d = new Newgraph(nvert);
        for (int i = 0; i < nedge; i++) {
            String[] str = sc.nextLine().split(" ");
            d.addEdge(Integer.parseInt(str[0]),
                Integer.parseInt(str[1]));
        }
        Bipartite b = new Bipartite(d);
        if (b.isBipartite()) {
            System.out.println("Graph is bipartite");
        } else {
            System.out.println("Graph is not a bipartite");
        }
    }
}
