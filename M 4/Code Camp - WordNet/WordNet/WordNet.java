import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;
/**
 * Class for word net.
 */
public class WordNet {
	HashMap<String, ArrayList<Integer>> hm = new HashMap<String, ArrayList<Integer>>();
    HashMap<Integer, String> hmn = new HashMap<Integer, String>();
    Digraph graph;
    SAP sapObj;
    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) throws Exception {
        Scanner sc1 = new Scanner(new File("Files\\" + synsets));
        Scanner sc2 = new Scanner(new File("Files\\" + hypernyms));

    	while(sc1.hasNextLine()) {
    		String[] input = sc1.nextLine().split(",");
    		hmn.put((Integer.parseInt(input[0])), input[1]);
            String[] words = input[1].split(" ");
            for (int i = 0; i < words.length; i++) {
    		    if (hm.containsKey(words[i])) {
    			    ArrayList a1 = hm.get(words[i]);
    			    a1.add(input[0]);
    		    } else {
    			    ArrayList<Integer> a2 = new ArrayList<Integer>();
    			    a2.add(Integer.parseInt(input[0]));
    		    	hm.put(words[i], a2);
    		    }
            }
    	}

    	graph = new Digraph(hm.size());
    	while(sc2.hasNextLine()) {
    		String input1[] = sc2.nextLine().split(" ");
    		for (int i = 1; i < input1.length; i++) {
    			graph.addEdge(Integer.parseInt(input1[0]), Integer.parseInt(input1[1]));
    		}
    	}
    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return null;
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
    	return false;
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
    	ArrayList id1 = hm.get(nounA);
    	ArrayList id2 = hm.get(nounB);
    	sapObj = new SAP(graph);
    	return sapObj.length(id1, id2);
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
    	ArrayList id1 = hm.get(nounA);
    	ArrayList id2 = hm.get(nounB);
    	sapObj = new SAP(graph);
    	int ans = sapObj.ancestor(id1, id2);
        return hmn.get(ans);
    }
}
