import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Query class constructs a Query object containing a PrintWriter object and binary tree provided by the main method.
 * The object allows for the user to search for string values from the .txt file. If they are found, then information
 * related to the words are revealed; if not, then the user is asked whether they would like to search for another 
 * word or not.
 */

public class Query {
	private PrintWriter pw; 
	private ObjectBinaryTree t;

	/**
	 * Query object constructor
	 * @param PrintWriter p = object containing csis_binarytrees.txt file provided by the main method.
	 * @param ObjectBinaryTree tree = binary tree created in Xref class that is searched in this class.
	 */
	
	public Query(PrintWriter p, ObjectBinaryTree tree) {
		pw = p;
		t = tree;
	}
	
	/**
	 * ask method allows the user to search the binary tree (or .txt file) for a desired word.
	 * If the word is found, then its number of occurrences and other info are outputed.
	 * The process takes place inside of a do/while loop which only terminates if the user 
	 * inputs the string "n".
	 */
	
	public void ask() {
		Scanner in = new Scanner(System.in);
		String choice;
		
		do {
			System.out.print("Enter the word you would like to try to find in the file: ");
			pw.print("Enter the word you would like to try to find in the file: ");
			choice = in.next();	
			System.out.println(choice);
			pw.println(choice);
			if(t.searchBST(new Word(pw, choice, new LinePosition())) != null) {
				Word found = (Word) t.searchBST(new Word(pw, choice, new LinePosition())).getInfo();
				found.visit();
			}
			else {
				System.out.println("Sorry, but the word you are looking for is not on the file.");
				pw.println("Sorry, but the word you are looking for is not on the file.");
			}
			System.out.print("Search another word? (enter n to quit): ");
			pw.print("Search another word? (enter n to quit): ");
			choice = in.next();
			System.out.println(choice);
			pw.println(choice);
		} while(!(choice.equals("n")));
		System.out.println("Goodbye");
		pw.println("Goodbye");
	}
}