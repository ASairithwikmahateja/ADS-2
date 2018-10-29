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
        String type = sc.nextLine();
        int nvertices = Integer.parseInt(sc.nextLine());
        int nedges = Integer.parseInt(sc.nextLine());
        String[] keys = sc.nextLine().split(",");
        Newgraph g = new Newgraph(nvertices);
        while (sc.hasNext()) {
            String[] conn = sc.nextLine().split(" ");
            g.addEdge(Integer.parseInt(conn[0]),
                Integer.parseInt(conn[1]));
        }
        switch (type) {
            case "List":
            try {
                g.listdisplay(nvertices, nedges, keys);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
            case "Matrix":
            try {
                g.matrixdisplay(nvertices, nedges);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
            default:
            break;
        }
    }
}

