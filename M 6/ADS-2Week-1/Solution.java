import java.util.Scanner;
/**
 * Class for page rank.
 */
class PageRank {
	/**
	 * Digraph g.
	 */
	private Digraph g;
	/**
	 * initial vertex.
	 */
	private int v = 0;
	/**
	 * rank array.
	 */
	private double[] rankar;
	/**
	 * Constructs the object.
	 */
	PageRank(Digraph g) {
		for (int i = 0; i < g.V(); i++) {
			rankar[i] = 1 / g.V();
			System.out.println(rankar[i]);
		}
		if (g.adj(v) != null) {
	 		for (int z : g.adj(v)) {
	   			rankar[v] += getPR(z) / g.outdegree(z);
	   		}
	   	} else {
	   		for (int i = 0; i < g.V(); i++) {
	   	    	g.addEdge(v, i);
	    	}
	    }
	}

	public double getPR(int v) {
	// 	for (int i = 0; i < 1000; i++) {
	// 		if (rankar[v] == rankar[g.adj(v)]) {
	// 			return;
	// 		}
	// 	}
		return rankar[v];
	}

	public String toString() {
		String str = " ";
		for (int i = 0; i < g.V(); i++) {
			str = i + " - " + getPR(v);	
		}
		return str;
	}
}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices
        Scanner sc = new Scanner(System.in);
        int nvert = Integer.parseInt(sc.nextLine());
        Digraph dg = new Digraph(nvert);
		// iterate count of vertices times 
		// to read the adjacency list from std input
		// and build the graph
		for (int i = 0; i < nvert; i++) {
			String[] tok = sc.nextLine().split(" ");
			for (int j = 0; j < tok.length; j++) {
				dg.addEdge(Integer.parseInt(tok[0]),
					Integer.parseInt(tok[j]));
        	}
        }
        System.out.println(dg.toString());
		
		// Create page rank object and pass the graph object to the constructor
		PageRank pg = new PageRank(dg);
		// print the page rank object
		System.out.println(pg.toString());
		
		// This part is only for the final test case
		
		// File path to the web content
		String file = "WebContent.txt";
		
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
		
	}
}
