/**
 * Class for cc.
 */
public class CC {
    /**
     * marked[v] = has vertex v been marked?
     */
    private boolean[] marked;
    /**
     * id[v] = id of connected component containing v.
     */
    private int[] id;
    /**
     * size[id] = number of vertices in given component.
     */
    private int[] size;
    /**
     * number of connected components.
     */
    private int count;

    /**
     * Constructs the object.
     *
     * @param      G     The undirected graph
     */
    public CC(Graph G) {
        marked = new boolean[G.vertices()];
        id = new int[G.vertices()];
        size = new int[G.vertices()];
        for (int v = 0; v < G.vertices(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    /**
     * depth-first search for a Graph
     * The time complexity is O(N^2).
     *
     * @param      G     Graph
     * @param      v     int
     */

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    /**
     * Returns the component id of the connected component containing vertex.
     *
     * @param      v     vertex
     *
     * @return the component id of the connected component containing vertex.
     * @throws IllegalArgumentException unless 0 <= v < V.
     * The time complexity is O(1).
     */
    public int id(int v) {
        validateVertex(v);
        return id[v];
    }

    /**
     * Returns the number of vertices in the connected component containing vertex.
     *
     * @param      v     vertex
     *
     * @return the number of vertices in the connected component containing vertex .    
     * @throws IllegalArgumentException unless 0 <= v < V.
     */
    public int size(int v) {
        validateVertex(v);
        return size[id[v]];
    }

    /**
     * Returns the number of connected components in the graph.
     *
     * @return     the number of connected components in the graph.
     */
    public int count() {
        return count;
    }

    /**
     * Returns true if vertices v and w are in the same
     * connected component.
     *
     * @param      v     one vertex
     * @param      w     the other vertex
     *
     * @return     true if vertices v and w are in the same
     *         connected component; false otherwise
     * @throws IllegalArgumentException unless 0 <= v < V.
     * @throws IllegalArgumentException unless 0 <= w < V.
     * The time complexity is O(1).
     */
    public boolean connected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }

    /**
     * Returns true if vertices v and w are in the same
     * connected component.
     *
     * @param      v     one vertex
     * @param      w     the other vertex
     *
     * @return     true if vertices v and w are in the same
     *         connected component; false otherwise
     * @throws IllegalArgumentException unless 0 <= v < V.
     * @throws IllegalArgumentException unless 0 <= w < V.
     * @deprecated Replaced by {@link #connected(int, int)}.
     */
    @Deprecated
    public boolean areConnected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }

    /**
     * throw an IllegalArgumentException unless 0 <= v < V. 
     *
     * @param      v
     */
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}
