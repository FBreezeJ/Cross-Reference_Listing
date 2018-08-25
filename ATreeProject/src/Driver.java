/**
 * Project Title: Binary Tree Lab
 * Project Description: This program constructs an index, or a cross-reference listing, for text based documents. The program will read text from Lincoln's 
 * 						Gettysberg Address and adds notable words to a binary tree containing word object, which themselves house a string variable and 
 * 						a linear linked list containing the locations of every occurrence of the word in the text. Omitted words are stored in a hash table
 * 						represented by an array, and a minimal perfect hash function is calculated using Cichelli's algorithm. The hash table and description
 * 						of the hash function, the speech, every word and occurrence of the word in the speech, and, finally, the users input will be outputed
 * 						to the terminal window and .txt file.
 *   Version or Date: May 18, 2018.
 *   How to Start the Project: Press run driver and then enter the correct input via the keyboard.
 *   User Instructions: Enter the word you wish to find in the .txt file (Lincoln's speech).
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * The Driver class stores the main method, a Scanner object, a Hash object, an Xref object, and a Query Object. All of the data gathered from the .txt file
 * is called upon from the main method, and, finally, the user is asked to search items in the .txt file via the query object's ask method.
 */

public class Driver {
	
	/**
	 * Scanner in reads data from Lincoln's Gettysberg address.
	 * PrintWriter pw outputs the appropriate information to the csis_binarytrees.txt file.
	 * Hash hash constructs an object Hash that will create a hash table which stores words that are to be omitted ffrom the document.
	 * Xref object x will gather all of the approprate words from the .txt file getty and store them in a binary tree.
	 * Query q will allow the user to search the binary tree for desired words.
	 */
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("getty.txt"));
		PrintWriter pw = new PrintWriter(new File("csis_binarytrees.txt"));
		Hash hash = new Hash(pw);
		Xref x = new Xref(in, pw, hash);
	
		hash.getHashTable();
		hash.printHashTable();
		hash.getDescription();
		x.getWords();
		x.printWords();
		Query q = new Query(pw, x.getTree());
		q.ask();
	}
}
