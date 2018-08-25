/**
	 * ObjectTreeNode must implement the ObjectTreeNodeInterface and all of its methods.
	 */
public interface ObjectTreeNodeInterface {
	/**
	 * ObjectTreeNode must implement setInfo() method
	 * @param Object o = Object sent to ObjectTreeNode class.
	 */
    public void setInfo(Object o);
    /**
	 * ObjectTreeNode must implement getInfo() method
	 * @return Object o = Object sent to ObjectTreeNode class now returned to whatever method is calling method.
	 */
    public Object getInfo();
    /**
	 * ObjectTreeNode must implement setLeft() method
	 * @param ObjectTreeNode p = set left child of other node.
	 */
    public void setLeft(ObjectTreeNode p);
    /**
 	 * ObjectTreeNode must implement getLeft() method
 	 * @return ObjectTreeNode p = return left child.
 	 */
    public ObjectTreeNode getLeft();
    /**
 	 * ObjectTreeNode must implement setRight() method
 	 * @param ObjectTreeNode p = set right child of other node.
 	 */
    public void setRight(ObjectTreeNode p);
    /**
 	 * ObjectTreeNode must implement getRight() method
 	 * @return ObjectTreeNode p = return right child.
 	 */
    public ObjectTreeNode getRight();
}