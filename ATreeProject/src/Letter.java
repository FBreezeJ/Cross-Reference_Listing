/**
	 * Letter class constructs a Letter object containing a character letter value and an integer value that serves as a hash value.
	 * These values will be directly used in the getHash method of the Hash class.
	 */

public class Letter {
	private char letter;
	private int value;
	
	/**
	 * Letter constructor makes a Letter object with a character letter value and an integer hash value.
	 * @param char l = character letter that is to serve as the basis for a hash function.
	 * @param v = integer value that is to later represent the character letter's hash value.
	 */
	
	public Letter(char l, int v) {
		letter = l;
		value = v%27;
	}
	
	/**
	 * @return char letter = first or last character of an omitted word object
	 */
	
	public char getLetter() {
		return letter;
	}
	
	/**
	 * @param j = sets the hash value to a given integer j.
	 */
	
	public void setValue(int j) {
		value = j%27;
	}
	
	/**
	 * @return int value = returns integer hash value.
	 */
	
	public int getValue() {
		return value;
	}
	
	/**
	 * increments the value of the hash integer.
	 */
	
	public void add() {
		value++;
	}
}