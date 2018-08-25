/**
	 * the ObjectListNode class is a subclass of the ObjectListNodeInterface interface.
	 * All methods contained in the superclass must be included in the ObjectListNode class.
	 * This class creates an ObjectListNode object; these objects are to store information of what is stored
	 * in the ObjectListNode as well as what the next ObjectListNode is. 
	 * These ObjectListNode objects are to be stored in the ObjectList.
	 */

public class ObjectListNode implements ObjectListNodeInterface
{
	private Object info;
	private ObjectListNode next; 
	
	/**
	 * ObjectListNode constructor initializes info and next fields to null.
	 */
	
	public ObjectListNode() {
		info = null; 
		next = null;
	}
	
	/**
	 * ObjectListNode constructor initializes info Object to an Object o and the next node to null.
	 * @param Object o - ObjectListNode contains the information contained in the o object.
	 */
	
	public ObjectListNode(Object o) {
		info = o; 
		next = null; 
	}
	
	/**
	 * ObjectListNode constructor initializes info Object to an Object o and the next node to ObjectListNode p.
	 * @param Object o - ObjectListNode contains the information contained in the o object.
	 * @param ObjectListNode p = the ObjectListNode contains information on what the next ObjectListNode is: p.
	 */
	
	public ObjectListNode(Object o, ObjectListNode p) {
		info = o; 
		next = p;
	}
	
	/**
	 * setInfo() method sets the info objects information to the Object o.
	 * @param Object o - the info Object will contain the information in the o Object.
	 */
	
	public void setInfo(Object o) {
		info = o;
	}
	
	/**
	 * getInfo() method returns the information contained in the info Object.
	 * @return information contained within the info Object data.
	 */
	
	public Object getInfo() {
		return info;
	}
	
	/**
	 * setNext() method sets the next ObjectListNode's information to the ObjectListNode p.
	 * @param ObjectListNode p - an ObjectListNode object that will come after the current ObjectListNode.
	 */
	
	public void setNext(ObjectListNode p) {
		next = p;
	}
	
	/**
	 * getNext() method returns the ObjectListNode object that is contained within next.
	 * @return ObjectListNode - the ObjectListNode object that comes after the current ObjectListNode.
	 */
	
	public ObjectListNode getNext() {
		return next;
	}
}

