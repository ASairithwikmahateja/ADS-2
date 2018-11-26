/**
 * Class for digraph.
 */
public class Digraph {
    /**
     * number of vertices in this digraph.
     */
    private final int vert;
    /**
     * number of edges in this digraph.
     */
    private int edge;
    /**
     * adj[v] = adjacency list for vertex v.
     */
    private Bag<Integer>[] adj;
    /**
     * indegree[v] = indegree of vertex v.
     */
    private int[] indegree;
    /**
     * Initializes an empty digraph with <em>V</em> vertices.
     * @param  verta the number of vertices
     */
    public Digraph(final int verta) {
        this.vert = verta;
        this.edge = 0;
        indegree = new int[vert];
        adj = (Bag<Integer>[]) new Bag[vert];
        for (int v = 0; v < vert; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     * Returns the number of vertices in this digraph.
     * @return the number of vertices in this digraph
     * The time complexity is O(1).
     */
    public int vert() {
        return vert;
    }
    /**
     * Returns the number of edges in this digraph.
     * @return the number of edges in this digraph
     * The time complexity is O(1).
     */
    public int edge() {
        return edge;
    }
    /**
     * Adds the directed edge v→w to this digraph.
     * @param  v the tail vertex
     * @param  w the head vertex
     * The time complexity is O(1).
     */
    public void addEdge(final int v, final int w) {
        adj[v].add(w);
        indegree[w]++;
        edge++;
    }
    /**
     * Returns the vertices adjacent from
     * vertex {@code v} in this digraph.
     * @param  v the vertex
     * @return the vertices adjacent from vertex
     * {@code v} in this digraph, as an iterable
     * The time complexity is O(1).
     */
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
    /**
     * Returns the number of directed edges
     * incident to vertex {@code v}.
     * This is known as the <em>indegree</em>
     * of vertex {@code v}.
     * @param  v the vertex
     * @return the indegree of vertex {@code v}
     * The time complexity is O(1).
     */
    public int indegree(final int v) {
        return indegree[v];
    }
}
