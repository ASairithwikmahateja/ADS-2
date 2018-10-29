import java.util.Scanner;
/**
 * Interface for graph.
 */
interface Graph {
    /**
     * Vertices
     *
     * @return     int
     */
    public int vertices();
    /**
     * Edges
     *
     * @return     int
     */
    public int edges();
    /**
     * Adds an edge.
     *
     * @param      v     int
     * @param      w     int
     */
    public void addEdge(int v, int w);
    /**
     * Iterable
     *
     * @param      v     int
     *
     * @return     int
     */
    public Iterable<Integer> adj(int v);
    /**
     * Determines if it has edge.
     *
     * @param      v     int
     * @param      w     int
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(int v, int w);
}
/**
 * Class for graph.
 */
class newGraph implements Graph {
    /**
     * int vertice
     */
    private int vertices;
    /**
     * int edge
     */
    private int edges;
    /**
     * Bag adj
     */
    private Bag<Integer>[] adj;
    /**
     * string tokens
     */
    private String[] tokens;
    /**
     * Constructs the object.
     */
    private newGraph() {
    
    }
    /**
     * Constructs the object.
     *
     * @param      vert    The vert
     */
    newGraph(final int vert) {
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
    newGraph(Scanner scan) {
        this.vertices = Integer.parseInt(scan.nextLine());
        adj = (Bag<Integer>[]) new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new Bag<Integer>();
        }
        int edges = Integer.parseInt(scan.nextLine());
        tokens = scan.nextLine().split(",");
        for (int i = 0; i < edges; i++) {
            String[] inputs = scan.nextLine().split(" ");
            addEdge(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        }
    }
    /**
     * vertice method
     *
     * @return     int
     */
    public int vertices() {
        return vertices;
    }
    /**
     * edge method
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
    public void addEdge(int vertexOne, int vertexTwo) {
        adj[vertexOne].add(vertexTwo);
        adj[vertexTwo].add(vertexOne);
        edges++;
    }
    /**
     * Iterable method
     *
     * @param      vertex  The vertex
     *
     * @return     int
     */
    public Iterable<Integer> adj(int vertex) {
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
    public boolean hasEdge(int v, int w) {
        for(int k : adj[v]) {
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
     * @param      tokens     The tokens
     *
     * @throws     Exception  { exception_description }
     */
    public void listdisplay(int vert, int edg, String[] tokens) throws Exception {
        if (edg <= 1 && vert <= 1) {
            System.out.println(vertices() + " vertices" + ", " + edges() + " edges");
            throw new Exception("No edges");
        } else {
            System.out.println(vertices() + " vertices" + ", " + edges() + " edges");
            for (int i = 0; i < tokens.length; i++) {
            String str = "";
            str = tokens[i] + ": ";
            for (int k : adj(i)) {
                str = str + tokens[k] + " ";
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
    public void matrixdisplay(final int vert, final int edg) throws Exception {
        if (edg <= 1 && vert <= 1) {
            System.out.println(vertices() + " vertices" + ", " + edges() + " edges");
            throw new Exception("No edges");
        } else {
            System.out.println(vertices() + " vertices" + ", " + edges() + " edges");
            int[][] disp = new int[vert][vert];
            for (int i = 0; i  < vert; i++) {
                for (int j = 0; j < vert; j++) {
                    if (hasEdge(i, j)) {
                        disp[i][j] = 1;
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
