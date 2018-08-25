/**
	 * OmittedWord class constructs an OmittedWord object representing the words omitted from documentation in the getty.txt file.
	 * These words are present because of teh CichellisMethod class; the purpose of these objects is to index them based on the 
	 * occurrence of common letters within them (the first and last letters). This is how the Cichellis Algorithm functions. The 
	 * sorting of the words based on their common letter values allows for the letters to eventually be given unique values 
	 * necessary for the hash function to be a minimal perfect hash function.
	 */

public class OmittedWord {
	private String w; 
	private int v;
	
	/**
	 * parameterized constructor constructs an OmittedWord object containing a string and integer value
	 * @param String w = word from the omitted.txt file that is to be omitted from documentation in the Xref class.
	 * @param int v = integet value that serves as a common letter index; calculated by adding the commonality of the first and last letters of the word.
	 */
	
	public OmittedWord(String w, int v) {
		this.w = w;
		this.v = v;
	}
	
	/**
	 * @return String w = omitted word string.
	 */
	
	public String getWord() {
		return w;
	}
	
	/**
	 * @return int v = commonality index.
	 */
	
	public int getValue() {
		return v;
	}
	
	/**
	 * @param i = sets the commonality index to a given integer value provided from the CichellisMethod class.
	 */
	
	public void setValue(int i) {
		v = i;
	}
}