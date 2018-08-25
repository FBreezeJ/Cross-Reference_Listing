
/**
	 * LinePosition class constructs a LinePosition object that contains a default and parameterized constructor.
	 * Contains two integer values representing the address of a given word in the .txt file.
	 */

public class LinePosition {
	private int line;
	private int wordNumber;
	
	/**
	 * default constructor
	 */
	
	public LinePosition() {
	}
	
	/**
	 * parameterized constructor
	 * @param int l = the line address of the word 
	 * @param int wn = the line position address of the word
	 */
	
	public LinePosition(int l, int wn) {
		line = l;
		wordNumber = wn;
	}
	
	/**
	 * @return int line = the line address of the word
	 */
	
	public int getLine() {
		return line;
	}
	
	/**
	 * @return int wordNumber = the line position address of the word
	 */
	
	public int getWordNumber() {
		return wordNumber;
	}
}

