import java.io.PrintWriter;

/**
 * Word class constructs word objects containing a PrintWriter object, a String (word), and the Locations of the word within the file, which are then put into a linear linked list.
 */

public class Word implements Comparable, TreeComparable {
	private PrintWriter pw;
	private String word;
	private LinePosition lp;
	private ObjectList occurrences = new ObjectList();
	private int count;
	
	/**
	 * @param PrintWriter pw = contains csis_binarytrees.txt file.
	 * @param String w = a word provided from the Xref class read form the .txt file.
	 * @param LinePosition lp = LinePosition object that will be inserted into a linear linked list; represents location within file of word.
	 */
	
	public Word(PrintWriter pw, String w, LinePosition lp)  {
		this.pw = pw;
		word = w;
		occurrences.addFirst(lp);
		count = 1;
	}
	
	/**
	 * @return String word = word from Xref class
	 */
	
	public String getWord() {
		return word;
	}
	
	/**
	 * @return ObjectList occurrences = linked list containing LinePosition objects indicating every location within the file of the word.
	 */
	
	public ObjectList getOccurences() {
		return occurrences;
	}
	
	/**
	 * @return int count = the number of times the word appears in the file.
	 */
	
	public int getCount() {
		return count;
	}
	
	/**
	 * increments the number of times that the word appears in the file
	 */
	
	public void addCount() {
		count++;
	}
	
	/**
	 * method inherited from the TreeComparable interface which allows for comparisons to be made between Word objects within the ObjectBinaryTree.
	 * @param Object o = another Word object; comparison takes place between the Strings contained in the two word objects.
	 * @return int word.compareTo(node.getWord()) = 0 if equal, negative if this.word is higher in the alphabet, positive if it is lower.
	 */
	
	public int compareTo(Object o) {
		Word node = (Word)o;
		return word.compareTo(node.getWord());
	}
	
	/**
	 * operate method allows for the count variable to be incremented if a word that has already been encounted before is spotted again.
	 * The LinePosition from the duplicate word is added onto the original object's linear linked list.
	 * @param Object o = another Word object; the duplicate object's linked list is going to be added onto the original object's list.
	 */
	
	public void operate(Object o) {
		Word duplicate = (Word) o;
		this.addCount();
		occurrences.addLast(duplicate.getOccurences().getFirstNode());
	}
	
	/**
	 * prints out all of the relevant information of the word object.
	 * Object's string value is ouputed, as is the number of occurences in the file, and 
	 * the locations of the word within the file.
	 */
	
	public void visit() {
		ObjectListNode node = occurrences.getFirstNode();

		System.out.print(getWord() + " " + getCount() + " ");
		pw.println(getWord() + " " + getCount() + " ");

		while(node != null) {
			System.out.print(((LinePosition) node.getInfo()).getLine() + "-" + ((LinePosition) node.getInfo()).getWordNumber() + " ");
			pw.print(((LinePosition) node.getInfo()).getLine() + "-" + ((LinePosition) node.getInfo()).getWordNumber() + " ");
			node = node.getNext();
		}
		System.out.println();
		pw.println();
	}
}
