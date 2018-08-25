/**
	 * Comparable interface allows for comparisons to be drawn between two objects of the same type outside of the ObjectBinaryTree class.
	 * These comparisons would most likely take place in the linked list class.
	 */

public interface Comparable {
	/**
	 * @return integer value indicating if objects are more than, less than, or equal to each other in some way.
	 * @param Object o = object that is to be compared by an object of the same type.
	 */
    int compareTo(Object o);
}
