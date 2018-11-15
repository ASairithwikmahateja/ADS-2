import java.util.Scanner;
import java.util.ArrayList;

public class BoggleSolver {
	// Initializes the data structure using the given array of strings as the dictionary.
	// (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
	TST<Integer> tst;
	public BoggleSolver(String[] dictionary) {
		tst = new TST<Integer>();
		for (int i = 0; i < dictionary.length; i++) {
			tst.put(dictionary[i], i);
		}
	}

	// Returns the set of all valid words in the given Boggle board, as an Iterable.
	public Iterable<String> getAllValidWords(BoggleBoard board) {
		boolean[][] marked = new boolean[board.rows()][board.cols()];
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < board.rows(); i++) {
			for (int j = 0; j < board.cols(); j++) {
				String c = "" + board.getLetter(i, j);
				marked[i][j] = true;
				dfs(list, c, i, j, marked, board);

            }
		}
		return list;
	}
	public void dfs(ArrayList<String> lst, String ch, int row, int col, boolean[][] marked, BoggleBoard board) {
		if (ch.length() >= 3 && tst.contains(ch)) {
			if (!lst.contains(ch)) {
			    lst.add(ch);
			}
		}
		if (!tst.hasPrefix(ch)) {
            return;
		}
		for (int i = 0; i < board.rows(); i++) {
			for (int j = 0; j < board.cols(); j++) {
				if (marked[i][j] == true) {
					continue;
				}
				ch += "" + board.getLetter(i, j);
				marked[i][j] = true;
				dfs(lst, ch, i, j, marked, board);
            }
		}
	}

	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A through Z.)
	public int scoreOf(String word) {
		if (word.length() == 4 || word.length() == 3) {
			return 1;
		} else if (word.length() == 5) {
			return 2;
		} else if (word.length() == 6) {
			return 3;
		} else if (word.length() == 7) {
			return 5;
		} else if (word.length() >= 8) {
			return 11;
		} return 0;
	}
}