/** 
 * Class definition for a Node of a singly linked list of characters 
 */
public class Node {

	/* Note: these fields are public so that they can be directly accessed
	 * from outside this class.  For example, if v is a Node object, 
	 * then v.entry and v.next can be used to access these fields. */
	 
	public char entry;	//the bracket entry
	public Node next;		//refers to the next node in the list
	
	/** 
	 * Constructor: creates a node
	* @param e 
	*			entry
	*@param n 
	*			pointer
	 */
	public Node(char e, Node n) {
		entry = e;
		next = n;
	}
}
