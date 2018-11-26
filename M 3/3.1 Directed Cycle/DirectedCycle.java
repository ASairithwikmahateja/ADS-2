/**
 * Class for directed cycle.
 */
public class DirectedCycle {
    /**
     * marked[v] = has vertex v been marked?.
     */
    private boolean[] marked;
    /**
     * edgeTo[v] = previous vertex on path to v.
     */
    private int[] edgeTo;
    /**
     * onStack[v] = is vertex on the stack?.
     */
    private boolean[] onStack;
    /**
     * directed cycle (or null if no such cycle).
     */
    private Stack<Integer> cycle;

    /**
     * Determines whether the digraph {@code G}
     * has a directed cycle and, if so,
     * finds such a cycle.
     * @param dg the digraph
     */
    public DirectedCycle(final Digraph dg) {
        marked  = new boolean[dg.vert()];
        onStack = new boolean[dg.vert()];
        edgeTo  = new int[dg.vert()];
        for (int v = 0; v < dg.vert(); v++) {
            if (!marked[v] && cycle == null) {
                dfs(dg, v);
            }
        }
    }
    /**
     * check that algorithm computes either
     * the topological order or finds a directed cycle.
     * The time complexity is O(E), where E is no of Edges.
     * @param      dg     G of type Digraph.
     * @param      v     v of type int.
     */
    private void dfs(final Digraph dg, final int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : dg.adj(v)) {
            // short circuit if directed cycle found
            if (cycle != null) {
                return;
            } else if (!marked[w]) { // found new vertex, so recur
                edgeTo[w] = v;
                dfs(dg, w);
            } else if (onStack[w]) {  // trace back directed cycle
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }
    /**
     * Does the digraph have a directed cycle?
     * @return {@code true} if the digraph has
     * a directed cycle, {@code false} otherwise
     * The time complexity is O(1).
     */
    public boolean hasCycle() {
        return cycle != null;
    }
    /**
     * Returns a directed cycle if the digraph has
     * a directed cycle, and {@code null} otherwise.
     * @return a directed cycle (as an iterable)
     * if the digraph has a directed cycle,
     *    and {@code null} otherwise
     *    The time complexity is O(1).
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
}
