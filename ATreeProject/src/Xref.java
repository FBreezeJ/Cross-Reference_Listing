import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Xref class constructs an Xref object that contains two file object and a Hash object.
 * The class reads every word from Lincoln's speech and inserts the approprate words into a 
 * sorted binary tree.
 */

public class Xref {
	private Scanner in;
	private PrintWriter pw;
	private Hash h;
	private ObjectBinaryTree tree = new ObjectBinaryTree();
	
	/**
	 * Xref constructor
	 * @param Scanner i = object containing the getty.txt file provided by the main method.
	 * @param PrintWriter p = object containing the csis_binarytrees.txt file provided by the main method.
	 * @param Hash h = hash object created in the main method via calling upon the getHashTable method. Allows class to determine which words are appropriate for documentation.
	 */
	
	public Xref(Scanner i, PrintWriter p, Hash hash) {
		in = i;
		pw = p;
		h = hash;
	}
	
	/**
	 * getWords method reads in every line from the getty.txt file and splits the words into a String array. Each line is outputed after it is put into a String.
	 * Within a while loop, the split words are put into a Word object after being deemed appropriate for documentation (via hash function) and are then inserted
	 * into a binary tree.
	 */
	
	public void getWords() {
		int lineNumber = 0;

		while(in.hasNextLine()) {
			lineNumber += 1;
			String line = in.nextLine();
			String delims = "[ \\,\\.\\;]+";
			String[] strings = line.split(delims);
			int count = 0;
			int wordCount = 1;
			
			System.out.println(lineNumber + " " + line);
			pw.println(lineNumber + " " + line);
			while(count < strings.length) {
				if(h.searchHash(strings[count].toLowerCase()) == false) {
					Word w = new Word(pw, strings[count].toLowerCase(), new LinePosition(lineNumber, count+1));
					tree.insertBSTDuplicate(w);
				}
				count++;
				wordCount++;
			}
		}
		System.out.println();
		pw.println();
	}
	/**
	 * calls upon the ObjectBinaryTree class's inTrav method, which allows for the method to print out all of the words
	 * in the tree, alphabetically.
	 */
	
	public void printWords() {
		ObjectTreeNode t = tree.getRoot();
		tree.inTrav(t);
		System.out.println();
		pw.println();
	}
	
	/**
	 * @return tree = allows for the main method to pull the tree from the Xref class.
	 */
	
	public ObjectBinaryTree getTree() {
		return tree;
	}
}
