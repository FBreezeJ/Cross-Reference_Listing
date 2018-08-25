/**
	 * TreeComparable interface allows for Objects to be compared from the ObjectBinaryTree class.
	 * From there, then the objects will be compared in their appropriate classes via the Comparable interface.
	 */

public interface TreeComparable {
	/**
	 * @return integer value indicating if objects are more than, less than, or equal to each other in some way.
	 * @param Object o = object that is to be compared by an object of the same type.
	 */
    int compareTo(Object o);
	/**
	 * @param Object o = this method will determine what to do to duplicate objects according to the needs of the specific object being compared to in the ObjectBinaryTree class.
	 */
    void operate(Object o);
	/**
	 * will allow for the appropriate data to be printed to the terminal window and .txt file.
	 */
    void visit();
}
