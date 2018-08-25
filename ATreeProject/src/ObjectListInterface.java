/**
	 * the ObjectListInterface interface is the superclass of the ObjectList class.
	 * The ObjectListNode class must include all of the following methods.
	 */
public interface ObjectListInterface 
{
	/**
	 * ObjectList class must contain a getFirstNode method.
	 * @return ObjectListNode object.
	 */
	
	public ObjectListNode getFirstNode();
	
	/**
	 * ObjectList class must contain a getLastNode method.
	 * @return ObjectListNode object.
	 */
	
	public ObjectListNode getLastNode(); 
	
	/**
	 * ObjectList class must contain a getFirst method.
	 * @return Object.
	 */
	
	public Object getFirst();
	
	/**
	 * ObjectList class must contain a getLast method.
	 * @return Object.
	 */
	
	public Object getLast();
	
	/**
	 * ObjectList class must contain an addFirst method.
	 * @param accepts an Object o.
	 */
	
	public void addFirst(Object o);
	
	/**
	 * ObjectList class must contain an addFirst method.
	 * @param accepts an ObjectListNode p.
	 */
	
	public void addFirst(ObjectListNode p);
	
	/**
	 * ObjectList class must contain an addLast method.
	 * @param accepts an Object o.
	 */
	
	public void addLast(Object o);
	
	/**
	 * ObjectList class must contain an addLast method.
	 * @param accepts an ObjectListNode p.
	 */
	
	public void addLast(ObjectListNode p);
	
	/**
	 * ObjectList class must contain a removeFirst method.
	 * @return an Object.
	 */
	
	public Object removeFirst();
	
	/**
	 * ObjectList class must contain a removeLast method.
	 * @return an Object.
	 */
	
	public Object removeLast();
	
	/**
	 * ObjectList class must contain an insertAfter method.
	 * @return an ObjectListNode p.
	 * @return an Object o.
	 */
	
	public void insertAfter(ObjectListNode p, Object o);
	
	/**
	 * ObjectList class must contain an insertAfter method.
	 * @param an ObjectListNode p.
	 * @param an ObjectListNode q..
	 */
	
	public void insertAfter(ObjectListNode p, ObjectListNode q);
	
	/**
	 * ObjectList class must contain a deleteAfter method.
	 * @param an ObjectListNode p.
	 * @return an Object.
	 */
	
	public Object deleteAfter(ObjectListNode p);
	
	/**
	 * ObjectList class must contain an insert method.
	 * @param an Object o.
	 */
	
	public void insert(Object o);
	
	/**
	 * ObjectList class must contain an insert method.
	 * @param an ObjectListNode r.
	 */
	
	public void insert(ObjectListNode r);
	
	/**
	 * ObjectList class must contain a remove method.
	 * @param an Object o.
	 */
	
	public Object remove(Object o);
	
	/**
	 * ObjectList class must contain a contains method.
	 * @param an Object o.
	 * @return a boolean value.
	 */
	
	public boolean contains(Object o);
	
	/**
	 * ObjectList class must contain a select method.
	 * @param an Object o.
	 * @return an ObjectListNode.
	 */
	
	public ObjectListNode select(Object o);
	
	/**
	 * ObjectList class must contain an isEmpty method.
	 * @return a boolean value.
	 */
	
	public boolean isEmpty();
	
	/**
	 * ObjectList class must contain a clear method.
	 */
	
	public void clear();
	
	/**
	 * ObjectList class must contain a size method.
	 * @return an integer value.
	 */
	
	public int size();
	
	/**
	 * ObjectList class must contain a copyList method.
	 * @return an ObjectList object.
	 */
	
	public ObjectList copyList();
	
	/**
	 * ObjectList class must contain a reverse method.
	 */
	
	public void reverse();
}