import java.util.Scanner;
/**
 * Interface for graph.
 */
interface Graph {
    /**
     * Vertices.
     *
     * @return     int
     */
    int vertices();
    /**
     * Edges.
     *
     * @return     int
     */
    int edges();
    /**
     * Adds an edge.
     *
     * @param      v     int
     * @param      w     int
     */
    void addEdge(int v, int w);
    /**
     * Iterable.
     *
     * @param      v     int
     *
     * @return     int
     */
    Iterable<Integer> adj(int v);
    /**
     * Determines if it has edge.
     *
     * @param      v     int
     * @param      w     int
     *
     * @return     True if has edge, False otherwise.
     */
    boolean hasEdge(int v, int w);
}
/**
 * Class for graph.
 */
class Newgraph implements Graph {
    /**
     * int vertice.
     */
    private int vertices;
    /**
     * int edge.
     */
    private int edges;
    /**
     * Bag adj.
     */
    private Bag<Integer>[] adj;
    /**
     * string tokens.
     */
    private String[] tokens;
    /**
     * Constructs the object.
     */
    private Newgraph() {
    }
    /**
     * Constructs the object.
     *
     * @param      vert    The vert
     */
    Newgraph(final int vert) {
        this.vertices = vert;
        this.edges = 0;
        adj = (Bag<Integer>[]) new Bag[vert];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    /**
     * Constructs the object.
     *
     * @param      scan  The scan
     */
    Newgraph(final Scanner scan) {
        this.vertices = Integer.parseInt(scan.nextLine());
        adj = (Bag<Integer>[]) new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new Bag<Integer>();
        }
        int edg = Integer.parseInt(scan.nextLine());
        tokens = scan.nextLine().split(",");
        for (int i = 0; i < edg; i++) {
            String[] inputs = scan.nextLine().split(" ");
            addEdge(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        }
    }
    /**
     * vertice method.
     *
     * @return     int
     */
    public int vertices() {
        return vertices;
    }
    /**
     * edge method.
     *
     * @return     int
     */
    public int edges() {
        return edges;
    }
    /**
     * Adds an edge.
     *
     * @param      vertexOne  The vertex one
     * @param      vertexTwo  The vertex two
     */
    public void addEdge(final int vertexOne, final int vertexTwo) {
        adj[vertexOne].add(vertexTwo);
        adj[vertexTwo].add(vertexOne);
        edges++;
    }
    /**
     * Iterable.
     *
     * @param      vertex  The vertex
     *
     * @return     int
     */
    public Iterable<Integer> adj(final int vertex) {
        return adj[vertex];
    }
    /**
     * Determines if it has edge.
     *
     * @param      v     integer
     * @param      w     integer
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v, final int w) {
        for (int k : adj[v]) {
                if (k == w) {
                    return true;
                }
        } return false;
    }
    /**
     * display function of adjacency list.
     *
     * @param      vert       int
     * @param      edg        int
     * @param      tok        The tokens
     *
     * @throws     Exception  { exception_description }
     */
    public void display1(final int vert, final int edg,
        final String[] tok) throws Exception {
        if (edg <= 1 && vert <= 1) {
            System.out.println(vertices()
                + " vertices" + ", " + edges() + " edges");
            throw new Exception("No edges");
        } else {
            System.out.println(vertices()
                + " vertices" + ", " + edges() + " edges");
            for (int i = 0; i < tok.length; i++) {
            String str = "";
            str = tok[i] + ": ";
            for (int k : adj(i)) {
                str = str + tok[k] + " ";
            }
            System.out.println(str);
            }
        }
    }
    /**
     * display function of adjacency matrix list.
     *
     * @param      vert        int
     * @param      edg         int
     *
     * @throws     Exception  No edges
     */
    public void display2(final int vert,
        final int edg) throws Exception {
        if (edg <= 1 && vert <= 1) {
            System.out.println(vertices()
                + " vertices" + ", " + edges() + " edges");
            throw new Exception("No edges");
        } else {
            System.out.println(vertices()
                + " vertices" + ", " + edges() + " edges");
            int[][] disp = new int[vert][vert];
            for (int i = 0; i  < vert; i++) {
                for (int j = 0; j < vert; j++) {
                    if (hasEdge(i, j)) {
                        disp[i][j] = 0;
                    }
                }
            }
            for (int i = 0; i < vert; i++) {
                for (int j = 0; j < vert; j++) {
                    System.out.print(disp[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
