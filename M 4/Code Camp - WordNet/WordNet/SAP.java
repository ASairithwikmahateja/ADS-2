public class SAP {
    Digraph graph;
    int Distance = Integer.MAX_VALUE;
 
    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        graph = G;
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        ancestor(v, w);
        return Distance;
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        int ans = -1;
        BreadthFirstPaths b1 = new BreadthFirstPaths(graph, v);
        BreadthFirstPaths b2 = new BreadthFirstPaths(graph, w);
        for (int vertices = 0; vertices < graph.V(); vertices++) {
            if (b1.hasPathTo(vertices) && b2.hasPathTo(vertices)) {
                int tempDistance = b1.distTo(vertices) + b2.distTo(vertices);
                if (tempDistance < Distance) {
                    Distance = tempDistance;
                    ans = vertices;
                }
            }
        } return ans;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w){
    	ancestor(v, w);
    	return Distance;
        
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w){
        int ans = -1;
        for (int v1 : v) {
            for (int w1 : w) {
                ancestor(v1, w1);
            }
        } return ans;
    }
}