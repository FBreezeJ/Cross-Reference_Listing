 /**
 	 * ObjectBinaryTree must implement all methods from this interface.
 	 */
public interface ObjectBinaryTreeInterface {
	 /**
	  * ObjectBinaryTree must implement getRoot() method
	 * @return ObjectTreeNode representing the root of the Binary tree. 
	 */
	public ObjectTreeNode getRoot();
	 /**
	  * ObjectBinaryTree must implement setLeftChild() method
	 * @param ObjectTreeNode parent = parent node
	 * @param ObjectTreeNode r = left child node
	 */
	public void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r);
	 /**
	  * ObjectBinaryTree must implement setRightChild() method
	 * @param ObjectTreeNode parent = parent node
	 * @param ObjectTreeNode r = right child node
	 */
	public void setRightChild(ObjectTreeNode parent, ObjectTreeNode r);
	 /**
	  * ObjectBinaryTree must implement an insertBST() method
	 * @param Object o = Object to be inserted into a node and into the tree
	 */
	public void insertBST(Object o);
	/**
	  * ObjectBinaryTree must implement an insertBSTDuplicate() method
	 * @param Object o = duplicate object to be inserted into a node and into the tree
	 */
	public void insertBSTDuplicate(Object o);
	/**
	  * ObjectBinaryTree must implement a searchBST() method
	 * @return ObjectTreeNode to be returned that contains the object o; or null if not found 
	 * @param Object o = object to be searched in the tree
	 */
	public ObjectTreeNode searchBST(Object o);
	/**
	  * ObjectBinaryTree must implement a preTrav() method
	 * @param ObjectTreeNode tree = the root of the tree 
	 */
	public void preTrav(ObjectTreeNode tree);
	/**
	  * ObjectBinaryTree must implement an inTrav() method
	 * @param ObjectTreeNode tree = the root of the tree 
	 */
	public void inTrav(ObjectTreeNode tree);
	/**
	  * ObjectBinaryTree must implement a postTrav() method
	 * @param ObjectTreeNode tree = the root of the tree 
	 */
	public void postTrav(ObjectTreeNode tree);
	/**
	  * ObjectBinaryTree must implement a delete() method
	 * @param Object o = object to be deleted from the tree
	 */
	public void delete(Object o);
}
