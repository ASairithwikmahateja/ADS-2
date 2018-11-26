import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file name:");
		String file = sc.nextLine();
		System.out.println("Choose Symbol Table:");
		System.out.println("BST, LinearProbingHashST, RedBlackBST, SeparateChainingHashST, SequentialSearchST, BinarySearchST");
		String st = sc.nextLine();
		File dir = new File("E:\\ADS-2\\Assignment\\Week-4");
		for(File f : dir.listFiles()) {
			String fname = file+".csv";
			In in = new In(fname);
			Stopwatch sw = new Stopwatch();
			if(f.getName().equals(fname)) {
				switch(st) {
					case "BinarySearchST":
					BinarySearchST bin = new BinarySearchST();
					while((!(in.isEmpty()))) {
						String st1 = in.readString();
						String[] tokens = st1.split(",");
						bin.put(tokens[0], tokens[1]);
					}

					// System.out.println("put "+sw.elapsedTime());
					// Stopwatch stop = new Stopwatch();
					// System.out.println(bin.get("Baking Powder"));
					// System.out.println("get "+ stop.elapsedTime());
					break;
					case "SeparateChainingHashST":
					SeparateChainingHashST sch = new SeparateChainingHashST();
					while((!(in.isEmpty()))) {
						String st2 = in.readString();
						String[] tokens = st2.split(",");
						sch.put(tokens[0], tokens[1]);
					}

					// System.out.println("put "+sw.elapsedTime());
					// Stopwatch stop = new Stopwatch();
					// System.out.println(sch.get("1377766560"));
					// System.out.println("get "+ stop.elapsedTime());
					break;
					case "RedBlackBST":
					RedBlackBST rbt = new RedBlackBST();
					while((!(in.isEmpty()))) {
						String st3 = in.readString();
						String[] tokens = st3.split(",");
						rbt.put(tokens[0], tokens[1]);
					}

					// System.out.println("put "+sw.elapsedTime());
					// Stopwatch stop = new Stopwatch();
					// System.out.println(rbt.get("1377765960"));
					// System.out.println("get "+ stop.elapsedTime());
					break;
					case "SequentialSearchST":
					SequentialSearchST sst = new SequentialSearchST();
					while((!(in.isEmpty()))) {
						String st4 = in.readString();
						String[] tokens = st4.split(",");
						sst.put(tokens[0], tokens[1]);
					}

					// System.out.println("put "+sw.elapsedTime());
					// Stopwatch stop = new Stopwatch();
					// System.out.println(sst.get("1377768420"));
					// System.out.println("get "+ stop.elapsedTime());
					break;
					case "LinearProbingHashST":
					LinearProbingHashST lph = new LinearProbingHashST();
					while((!(in.isEmpty()))) {
						String st5 = in.readString();
						String[] tokens = st5.split(",");
						lph.put(tokens[0], tokens[1]);
					}

					// System.out.println("put "+sw.elapsedTime());
					// Stopwatch stop = new Stopwatch();
					// System.out.println(lph.get("1377769500"));
					// System.out.println("get "+ stop.elapsedTime());
					break;
					case "BST":
					BST bst = new BST();
					while((!(in.isEmpty()))) {
						String st6 = in.readString();
						String[] tokens = st6.split(",");
						bst.put(tokens[0], tokens[1]);
					}

					System.out.println("put "+sw.elapsedTime());
					Stopwatch stop = new Stopwatch();
					System.out.println(bst.get("1330429860"));
					System.out.println("get "+ stop.elapsedTime());
					break;
					default:
					System.out.println("Wrong Input");
					break;
				}
				break;
			}
		}	
	}
}