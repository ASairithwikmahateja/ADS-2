import java.util.Scanner;
/**
 * Class for page rank.
 */
class PageRank {
	/**
	 * Constructs the object.
	 */
	Digraph g;
	PageRank(Digraph dg) {
		g = dg;
	}
	
}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices
        Scanner sc = new Scanner(System.in);
        int nvert = Integer.parseInt(sc.nextLine());

		// iterate count of vertices times 
		// to read the adjacency list from std input
		// and build the graph
		for (int i = 0; i < nvert; i++) {
			String[] ed = sc.nextLine().split(" ");
        }
        Digraph dg = new Digraph(nvert);
		
		// Create page rank object and pass the graph object to the constructor
		PageRank pg = new PageRank(dg);
		// print the page rank object
		System.out.println(pg);
		
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
