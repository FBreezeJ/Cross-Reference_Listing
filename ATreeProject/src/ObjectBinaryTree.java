/**
	  * ObjectBinaryTree must implement allmethods from the ObjectBinaryTreeInterface interface.
	  * ObjectBinaryTree is a binary tree data structure that allows for any object to be organized within a 
	  * binary search tree.
	 */
public class ObjectBinaryTree implements ObjectBinaryTreeInterface{
	private ObjectTreeNode root;
	  
	/**
	  * default constructor that sets the ObjectTreeNode root to null;
	 */
	public ObjectBinaryTree() {
		root = null;
	}
	/**
	  * @return ObjectTreeNode root = first node in the tree.
	 */
	public ObjectTreeNode getRoot() {
		return root;
	}
	/**
	  *Sets the left child node of some parent node within the tree to r.
	 * @param ObjectTreeNode parent = parent node
	 * @param ObjectTreeNode r = left child node
	 */
	public void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r) {
		if (parent == null || parent.getLeft() != null) {
			System.out.println("Runtime Error: setLeftChild()");
			System.exit(1);
		}
		parent.setLeft(r);
	}
	/**
	  *Sets the right child node of some parent node within the tree to r.
	 * @param ObjectTreeNode parent = parent node
	 * @param ObjectTreeNode r = right child node
	 */
	public void setRightChild(ObjectTreeNode parent, ObjectTreeNode r){
		if (parent == null || parent.getRight() != null) {
			System.out.println("Runtime Error: setRightChild()");
			System.exit(1);
		}
		parent.setRight(r);
	}
	/**
	  * Inserts an object into its appropriate position within the tree given the value that it contains; determined by compareTo() method in the inserted object's class.
	  * @param Object o = Object to be inserted into a node and into the tree
	 */
	public void insertBST(Object o) {
		ObjectTreeNode p, q;
		ObjectTreeNode r = new ObjectTreeNode(o);
		
		if (root == null)
			root = r;
		else {
			p = root;
			q = root;
			while (q != null) {
				p = q;
				if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0 )
					q = p.getLeft();
				else
					q = p.getRight();
			}
			if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
				setLeftChild(p, r);
			else
				setRightChild(p, r);
		}
	}
	/**
	  * Inserts an object into its appropriate position within the tree given the value that it contains; 
	  * determined by compareTo() and operate() methods in the inserted object's class.
	 * @param Object o = duplicate object to be inserted into a node and into the tree
	 */
	public void insertBSTDuplicate(Object o) {
		ObjectTreeNode p, q;
		ObjectTreeNode r = new ObjectTreeNode(o);
		
		if (root == null)
			root = r;
		else {
			p = root;
			q = root;
			while (q != null && ((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) != 0) {
				p = q;
				if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
					q = p.getLeft();
				else
					q = p.getRight();
			}
			if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
				setLeftChild(p, r);
			else if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) > 0)
				setRightChild(p, r);
			else ((TreeComparable)(p.getInfo())).operate((TreeComparable)(r.getInfo()));
		}
	}
	/**
	  * searches for a given object within the ObjectBinaryTree and determines the ObjectTreeNode to which it belongs.
	 * @return ObjectTreeNode to be returned that contains the object o; or null if not found 
	 * @param Object o = object to be searched in the tree
	 */
	public ObjectTreeNode searchBST(Object o) {
		ObjectTreeNode p; 
		ObjectTreeNode r = new ObjectTreeNode(o);
	
		if(root != null) {
			p = root;
			while (p != null) {
				if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
					p = p.getLeft();
				else if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) > 0)
					p = p.getRight();
				else
					return p;
			}
		}
		return null;
	}
	/**
	  * Prints out a preTraversal of the tree by calling upon the Object's visit method.
	 * @param ObjectTreeNode tree = the root of the tree 
	 */
	public void preTrav(ObjectTreeNode tree) {
		if (tree != null) {
			((TreeComparable)tree.getInfo()).visit();
			preTrav(tree.getLeft());
			preTrav(tree.getRight());
		}
	}
	/**
	  * Prints out an inTraversal of the tree by calling upon the Object's visit method.
	 * @param ObjectTreeNode tree = the root of the tree 
	 */
	public void inTrav(ObjectTreeNode tree) {
		if (tree != null) {
			inTrav(tree.getLeft());
			((TreeComparable)tree.getInfo()).visit();
			inTrav(tree.getRight());
		}
	}
	/**
	  * Prints out a postTraversal of the tree by calling upon the Object's visit method.
	 * @param ObjectTreeNode tree = the root of the tree 
	 */
	public void postTrav(ObjectTreeNode tree) {
		if (tree != null) {
			postTrav(tree.getLeft());
			postTrav(tree.getRight());
			((TreeComparable)tree.getInfo()).visit();
		}
	}
	/**
	  * deletes the node within the tree that contains the specified object provided in the parameter
	 * @param Object o = object to be deleted from the tree
	 */
	public void delete(Object o) {
		ObjectTreeNode s, t, v;
		boolean found = false;
		ObjectTreeNode r = new ObjectTreeNode(o);
		ObjectTreeNode p = root;
		ObjectTreeNode q = null;
	
		while (p != null && !found) {
			if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) == 0)
				found = true;
			else {
				q = p;
				if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
					p = p.getLeft();
				else
					p = p.getRight();
			}
		}
		if (found) {
			if (p.getLeft() == null)
				v = p.getRight();
			else if (p.getRight() == null)
				v = p.getLeft();
			else {
				t = p;
				v = p.getRight();
				s = v.getLeft();
				while (s != null) {
					t = v;
					v = s;
					s = v.getLeft();
				}
				if (t != p) {

					t.setLeft(v.getRight());

					v.setRight(p.getRight());
				}
				v.setLeft(p.getLeft());
			}
			
			if (q == null)

				root = v;
			else if (p == q.getLeft())
				q.setLeft(v);
			else q.setRight(v);
		}
	}
}