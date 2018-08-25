/**
	 * the ObjectListNodeInterface interface is the superclass of the ObjectListNode class.
	 * The ObjectListNode class must include all of the following methods.
	 */

public interface ObjectListNodeInterface 
{
	/**
	 * ObjectListNode class must contain a setInfo method.
	 * @param accepts an object o.
	 */
	public void setInfo(Object o);
	
	/**
	 * ObjectListNode class must contain a getInfo() method.
	 * @return an Object contained within the ObjectListNode object.
	 */
	
	public Object getInfo();
	
	/**
	 * ObjectListNode class must contain a setNext() method.
	 * @param accepts an object p.
	 */
	
	public void setNext(ObjectListNode p);
	
	/**
	 * ObjectListNode class must contain a getNext() method.
	 * @return an ObjectListNode object contained within the ObjectListNode object.
	 */
	
	public ObjectListNode getNext();
}
