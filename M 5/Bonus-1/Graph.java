class Graph {
    /**
     * vertices.
     */
    private int v;
    /**
     * edges.
     */
    private int e;
    /**
     * array of bag type.
     */
    private Bag<Integer>[] adj;
    /**
     * marked array.
     */
    private boolean[] marked;
    /**
     * Constructs the object.
     */
    Graph() {
    }
    /**
     * Constructs the object.
     *
     * @param      v1    The v1
     */
    Graph(final int v1) {
        this.v = v1;
        this.e = 0;
        adj = (Bag<Integer>[]) new Bag[v1];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    /**
     * Gets the v.
     *
     * @return     The v.
     */
    public int getV() {
        return v;
    }
    /**
     * Gets the e.
     *
     * @return     The e.
     */
    public int getE() {
        return e;
    }
    /**
     * get bag array.
     *
     * @return     list
     */
    public Bag<Integer>[] getadj() {
        return adj;
    }
    /**
     * returns number of vertices.
     *
     * @return    no of vertices
     */
    public int vertices() {
        return v;
    }
    /**
     * returns number of edges.
     *
     * @return    no of edges
     */
    public int edges() {
        return e;
    }
    /**
     * Adds an edge.
     * complexity of method is O(1)
     *
     * @param      v1    integer
     * @param      w1     integer
     */
    public void addEdge(final int v1, final int w1) {
        e++;
        adj[v1].add(w1);
        adj[w1].add(v1);
    }
    /**
     * returns all the values in list.
     * complexity of this method is O(1)
     *
     * @param      v1     integer
     *
     * @return   list.
     */
    public Iterable<Integer> adj(final int v1) {
        return adj[v1];
    }
    /**
     * Determines if it has edge.
     * complexity of this method is O(N)
     *
     * @param      v1     integer
     * @param      w1     integer
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(final int v1, final int w1) {
        for (int k : adj[v1]) {
                if (k == w1) {
                    return true;
                }
        }
        return false;
    }
    // does this graph have a self loop?
    // side effect: initialize cycle to be self loop
    public boolean hasSelfLoop(int v) {
        for (int w : adj(v)) {
            if (v == w) {
                return true;
            }
        }
        return false;
    }
    // does this graph have two parallel edges?
    // side effect: initialize cycle to be two parallel edges
    public boolean hasParallelEdges(int v) {
        marked = new boolean[vertices()];
        for (int w : adj(v)) {
            if (marked[w]) {
                return true;
            }
            marked[w] = true;
        }
        return false;
    }
}
