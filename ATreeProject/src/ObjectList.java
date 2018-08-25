/**
	 * the ObjectList class is a subclass of the ObjectListInterface interface.
	 * All methods contained in the superclass must be included in the ObjectList class.
	 * This class creates an ObjectList object; this object is to store ObjectListNode objects which 
	 * contain information as well as a pointer to the next ObjectListNode in the ObjectList
	 * In this program, the ObjectList stores ObjectListNodes which contain Employee object only.
	 */

public class ObjectList implements ObjectListInterface
{
	private ObjectListNode list;
	private ObjectListNode last;
	
	/**
	 * ObjectListNode constructor initializes the list ObjectListNode to null and 
	 * the last ObjectListNode to null..
	 */
	
	public ObjectList() {
		list = null; 
		last = null; 
	}
	
	public ObjectList(Object o) {
		addFirst(o);
	}
	
	/**
	 * @return ObjectListNode list - the first ObjectListNode in the ObjectList.
	 */
	
	public ObjectListNode getFirstNode() {
		return list; 
	}
	
	/**
	 * @return ObjectListNode last - the last ObjectListNode in the ObjectList.
	 */
	
	public ObjectListNode getLastNode() {
		return last; 
	}
	
	/**
	 * returns the information stored in the first ObjectListNode in the ObjectList unless the list is composed only of a null.
	 * @return Object list.getInfo() - the Object stored in the first ObjectListNode in the list.
	 */
	
	public Object getFirst() {
		if(list == null) {
			System.out.println("Runtime Error: getFirst()");
			System.exit(1);
		}
		return list.getInfo();
	}
	
	/**
	 * returns the information stored in the last ObjectListNode in the ObjectList unless the list is composed only of a null.
	 * @return Object last.getInfo() - the Object stored in the last ObjectListNode in the list.
	 */
	
	public Object getLast() {
		if(list == null) {
			System.out.println("Runtime Error: getLast()");
			System.exit(1);
		}
		return last.getInfo();
	}
	
	/**
	 * stores an object into the newly created first ObjectListNode of the ObjectList.
	 * If list is initially composed of only a null, then this newly created first ObjectListNode is also the last node in the list.
	 * @param Object o - the Object which is to be stored in the first ObjectListNode of the list.
	 */
	
	public void addFirst(Object o) {
		ObjectListNode p = new ObjectListNode(o, list);
		if(list == null) last = p;
		list = p;
	}
	
	/**
	 * adds the first ObjectListNode into the ObjectList.
	 * If list is initially composed of only a null, then this newly created first ObjectListNode is also the last node in the list.
	 * @param ObjectListNode p - the node which is to be the first ObjectListNode in the list.
	 */
	
	public void addFirst(ObjectListNode p) {
		if(p == null) {
			System.out.println("Runtime Error: addFirst()");
			System.exit(1);
		}
		p.setNext(list);
		if(list == null) last = p;
		list = p;
	}
	
	/**
	 * stores an object into the newly created last ObjectListNode of the ObjectList.
	 * If list is initially composed of only a null, then this newly created last ObjectListNode is also the first node of the list.
	 * @param Object o - the Object which is to be stored in the last (or first) ObjectListNode of the list.
	 */
	
	public void addLast(Object o) {
		ObjectListNode p = new ObjectListNode(o);
		if(list == null) list = p;
		else last.setNext(p);
		last = p;
	}
	
	/**
	 * adds the last ObjectListNode into the ObjectList
	 * If list is initially composed of only a null, then this newly created last ObjectListNode is also the first node in the list.
	 * @param ObjectListNode p - the node which is to be the last (or first) ObjectListNode in the list.
	 */
	
	public void addLast(ObjectListNode p) {
		if(p == null) {
			System.out.println("Runtime Error: addLast()");
			System.exit(1);
		}
		p.setNext(null);
		if(list == null) list = p;
		else last.setNext(p);
		last = p;
	}
	
	/**
	 * removes the first node in the list from the list entirely and sets the next node as the first node.
	 * If the list is composed of a null only, then a runtime is outputed.
	 * If the list only contains one node, then the list and last values are set to null.
	 * @return Object p.getInfo() - the Object stored in the new first ObjectListNode of the list.
	 */
	
	public Object removeFirst() {
		if(list == null) {
			System.out.println("Runtime Error: removeFirst()");
			System.exit(1);
		}
		ObjectListNode p = list;
		list = p.getNext();
		if(list == null) last = null;
		return p.getInfo();
	}
	
	/**
	 * adds the final ObjectListNode from the ObjectList.
	 * If list is initially composed of only a null, then a runtime error is outputed.
	 * If there is only one node in the list, then list and last are both set back to null.
	 * @return Object p.getInfo() - the new last node in the list.
	 */
	
	public Object removeLast() {
		if(list == null) {
			System.out.println("Runtime Error: removeLast()");
			System.exit(1);
		}
		ObjectListNode p = list;
		ObjectListNode q = null;
		while(p.getNext() != null) {
			q = p; 
			p = p.getNext();
		}
		if(q == null) {
			list = null;
			last = null;
		}
		else {
			q.setNext(null);
			last = q;
		}
		return p.getInfo();
	}
	
	/**
	 * inserts an ObjectListNode containing an object o after ObjectListNode p.
	 * If the list is empty or ObjectListNode is null, then a runtime error is outputed.
	 * @param ObjectListNode p - the node to which another node is inserted after.
	 * @param Object o - the information that is to be stored in a new ObjectListNode q.
	 */
	
	public void insertAfter(ObjectListNode p, Object o) {
		if(list == null || p == null) {
			System.out.println("Runtime Error: insertAfter()");
			System.exit(1);
		}
		ObjectListNode q = new ObjectListNode(o, p.getNext());
		p.setNext(q);
		if(q.getNext() == null) last = q;
	}
	
	/**
	 * inserts an ObjectListNode after ObjectListNode p.
	 * If the list is empty or ObjectListNode is null, then a runtime error is outputed.
	 * @param ObjectListNode p - the node to which another node is inserted after.
	 * @param Object q - the node that is to be inserted after ObjectListNode p..
	 */
	
	public void insertAfter(ObjectListNode p, ObjectListNode q) {
		if(list == null || p == null || q == null) {
			System.out.println("Runtime Error: insertAfter()");
			System.exit(1);
		}
		q.setNext(p.getNext());
		p.setNext(q);
		if(last.getNext() != null) last = q;
	}
	
	/**
	 * deletes the node which comes after ObjectListNode p.
	 * If the list is empty, p = null, or p is the last node in the list, then a runtime error is outputed.
	 * @param ObjectListNode p - the node that comes after p is to be deleted.
	 * @return q.getInfo() - the node which is deleted after ObjectListNode p.
	 */
	
	public Object deleteAfter(ObjectListNode p) {
		if(list == null || p == null || p.getNext() == null) {
			System.out.println("Runtime Error: deleteAfter()");
			System.exit(1);
		}
		ObjectListNode q = p.getNext();
		p.setNext(q.getNext());
		if(p.getNext() == null) last = p;
		return q.getInfo();
	}
	
	/**
	 * orderly inserts an Object o into the list between the nodes which are less than and more than/null the info contained in Object o.
	 * @param Object o - the Object which is to be inserted into the list in its proper, orderly place.
	 */
	
	public void insert(Object o) {
		ObjectListNode p = list; 
		ObjectListNode q = null; 
		while(p != null && ((Comparable)o).compareTo(p.getInfo()) > 0) {
			q = p; 
			p = p.getNext();
		}
		if(q == null) addFirst(o);
		else insertAfter(q, o);
	}
	
	/**
	 * orderly inserts an ObjectListNode r into the list between the nodes which are less than and more than/null the info contained in Object o, respectively.
	 * @param ObjectListNode r - the ObjectListNode which is to be inserted into the list in its proper, orderly place.
	 */
	
	public void insert(ObjectListNode r) {
		ObjectListNode p = list; 
		ObjectListNode q = null; 
		while(p != null && ((Comparable)r.getInfo()).compareTo(p.getInfo()) > 0) {
			q = p; 
			p = p.getNext();
		}
		if(q == null) addFirst(r);
		else insertAfter(q, r);
	}
	
	/**
	 * removes the ObjectListNode from the ObjectList which contains the information contained in Object o.
	 * If the list does not contain o, then null is returned.
	 * @param Object o - the Object which is to be deleted form the list along with the ObjectListNode which it is contained in.
	 * @return the node which is deleted from the list, or null if the list is empty or doensn't contain o.
	 */
	
	public Object remove(Object o) {
		ObjectListNode p = list; 
		ObjectListNode q = null; 
		while(p != null && ((Comparable)o).compareTo(p.getInfo()) != 0) {
			q = p; 
			p = p.getNext();
		}
		if(p == null) return null;
		else return q == null ? removeFirst() : deleteAfter(q);
	}
	
	/**
	 * determines whether or not the list contains an ObjectListNode with the information stored in Object o.
	 * @param Object o - the Object which is to be scanned for in the list.
	 * @return boolean - true or false value determining whether or not Object o is in the list.
	 */
	
	public boolean contains(Object o) {
		ObjectListNode p = list;
		while(p != null && ((Comparable)o).compareTo(p.getInfo()) != 0) p = p.getNext();
		return p != null;
	}
	
	/**
	 * @param Object o - the Object which is to be scanned for in the list.
	 * @return ObjectListNode p - the ObjectListNode which contains the information stored in Object o.
	 */
	
	public ObjectListNode select(Object o) {
		ObjectListNode p = list; 
		while(p != null) {
			if(((Comparable)o).compareTo(p.getInfo()) == 0) return p;
			else p = p.getNext();
		}
		return null;
	}
	
	/**
	 * determines if the list is empty depending on whether or not list = null.
	 * @return boolean - true or false depending on whether or not the list is empty.
	 */
	
	public boolean isEmpty() {
		return list == null;
	}
	
	/**
	 * sets list and last to null, thus clearing the ObjectList of all information.
	 */
	
	public void clear() {
		list = null; 
		last = null;
	}
	
	/**
	 * determines the number of nodes contained in the list.
	 * @return int count - the number of nodes in the list, which represents the size of the list. 
	 */
	
	public int size() {
		int count = 0; 
		ObjectListNode p = list; 
		while(p != null) {
			++count; 
			p = p.getNext();
		}
		return count;
	}
	
	/**
	 * creates a new ObjectList object, newList, and copies the contents of the current list onto that list. 
	 * @return ObjectList newList - the new list which is a copy of the current list. 
	 */
	
	public ObjectList copyList() {
		ObjectListNode p = null; 
		ObjectListNode q = null; 
		ObjectListNode r = list;
		
		if(isEmpty()) return null;
		ObjectList newList = new ObjectList();
		while(r != null) {
			p = new ObjectListNode(r.getInfo());
			if(newList.isEmpty()) newList.addFirst(p);
			else q.setNext(p);
			q = p; 
			r = r.getNext();
		}
		newList.last = p;
		return newList;
	}
	
	/**
	 * reverses the order of the sequence of nodes within the ObjectList, thus reversing the list. 
	 */
	
	public void reverse() {
		ObjectListNode p = list; 
		ObjectListNode q = null; 
		ObjectListNode r; 
		
		while(p != null) {
			r = q; 
			q = p;
			p = p.getNext();
			q.setNext(r);
		}
		last = list;
		list = q;
	}
}