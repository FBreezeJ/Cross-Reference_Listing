 /**
 	 * ObjectTreeNode class builds nodes containing object information and pointers to nodes on the bottom right and bottom left.
 	 * These nodes are to be inserted into the ObjectBinaryTree class.
 	 * All methods are implemented from the ObjectTreeNodeInterface class
 	 */
public class ObjectTreeNode implements ObjectTreeNodeInterface {
	private Object info;
	private ObjectTreeNode left;
	private ObjectTreeNode right;
  
    /**
 	 * default constructor initializes object info and pointers to other nodes as null
 	 */
	
	public ObjectTreeNode() {
		info = null;
		left = null;
		right = null;
	}
  
    /**
 	 * parameterized constructor; node pointers are still null, however
 	 * @param Object o = Object information 
 	 */
	
	public ObjectTreeNode (Object o) {
		info = o;
		left = null;
		right = null;
	}
	
    /**
 	 * @param o = object info set to object sent to this class.
 	 */
  
	public void setInfo(Object o) {
		info = o;
	}
	
	   /**
	 	 * @returns Object info = object info, o in the setInfo method.
	 	 */
  
	public Object getInfo() {
		return info;
	}
	
	   /**
	 	 * @param ObjectTreeNode p = bottom left pointer variable is now set to point to a new ObjectTreeNode
	 	 */
  
	public void setLeft(ObjectTreeNode p) {
		left = p;
	}
	
	 /**
 	 * @return ObjectTreeNode left = bottom left pointer variable 
 	 */
  
	public ObjectTreeNode getLeft() {
		return left;
	}
	
	 /**
 	 * @param ObjectTreeNode p = bottom right pointer variable is now set to point to a new ObjectTreeNode
 	 */
  
	public void setRight(ObjectTreeNode p) {
		right = p;
	}
	
	 /**
	 * @return ObjectTreeNode right = bottom right pointer variable 
	 */
  
	public ObjectTreeNode getRight() {
		return right;
	}
}
