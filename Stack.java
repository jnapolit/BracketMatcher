/**
 * Class definition for a Stack of a singly linked list of brackets
 */
public class Stack{
	
	public Node top;	//declares a top variable
	public int size;	//declares a size variable
	
	
	/** 
	 * Constructor: creates a stack with a top of null and a size of zero. 
	 */
	public Stack(){
		
		size=0;		
		top=null;		
	}
	
	
	/** 
	 * Displays all the items in the Stack 
	 */
	public void display() {
		
		Node cur = top; 		//sets cur to be the top 		
		while (cur != null)		//loop through the whole list
		{		
			System.out.println (cur.entry);	//print out the item you are currently on
			cur= cur.next;			//then go to the next one in the list
		
		}		
	}
	
	
	/** 
	 * Pushes characters onto the top of the stack  
	*@param bracket
	*				bracket you are pushing 
	 */
	
	public void push(char bracket){
		
		Node b = new Node (bracket, null);	//creates a new node for this new bracket
		b.next=top;		//connect this new node to the one on the top of the stack
		top=b;		//make this new node the top
		size++;		//increase the size
	}
	
	
	/** 
	 * Pops the top character off stack. 
	*@return 
	*			null if it is an empty Stack
	*@return 
	*			the element that was popped 
	 */
	public char pop(){
		
		if(size>0){		//if the size is greater than zero 
			char  poped = top.entry;	//save the first element in the list out to a variable
			top=top.next; 	//assign the next one in the list to be the top
			size--;		//decrease the size
			return poped;		//return what used to be the top of the stack
		}
		return 'n'+'u'+'l'+'l'; 	//otherwise return ?
	}
	
	
	/** 
	 * It peeks at the first character in the stack 
	*@return 
	*			the top entry 
	 */
	public char peek(){
		
		if (top==null)		//if the stack is empty and top is null
			return 'n'+'u'+'l'+'l';		//return a ? 
		else
			return top.entry;		//else return the top's entry 
	}
	
	
	/** 
	 * Checks to see if the stack is empty 
	*@return
	*		 boolean whether it's empty 	
	 */
	public boolean isEmpty(){		
		
		return (size==0);	//return the boolean of does the size equal 0
	}
	
	
	/** 
	*@return size of stack 
	 */
	public int size(){
		
		return size;		//returns the value of the variable size
	}
	
	

	public static void main (String [] args){
		
		Stack testStack= new Stack(); 	
		
		testStack.push(']'); 	
		testStack.push('(');
		testStack.push('}'); 
		
		testStack.pop();
		testStack.pop();
		char return1 = testStack.pop();
		System.out.println(return1+" the symbol before should show it poped the ]");
		testStack.pop(); 
		char return2 = testStack.pop(); 
		System.out.println(return2+" the symbol before should show it poped the nothing");
		
		testStack.push(']');
		
		char return3 = testStack.peek(); 
		System.out.println(return3 + "what is peeked");
		
		boolean isempty = testStack.isEmpty();
		System.out.println(isempty + " the list is empty"); 
		
		int size = testStack.size(); 
		System.out.println(size); 
		
		testStack.display(); 
	}	
	
}
	
