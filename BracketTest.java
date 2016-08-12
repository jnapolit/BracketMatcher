/** 
* This class is used to determine whether a string contains matching brackets
 */

public class BracketTest		
{
	
	public char[] openb = {'(','[' , '{' , '<'}; 	//initalizes and declares the variable open b to be open brackets
	public char[] closedb = {')' ,']' ,'}' ,'>'};   //initalizes and declares the variable closted b to be closed brackets 
	
    
    /** 
	 * This method checks to see if a char is an open bracket
	*@param 
	*		char you are trying to test
	*@return 
	*		It returns the boolean of this statement 
	 */
    
	public boolean isOpeningBracket(char c)
	{
		
		for (int i=0; i<4; i++)   //go through each item in the array openb 
		{
			if (c==openb[i])     //if the char in question is equal to one of these brackets
			{
				return true;     //return true
			}
		}		
		return false;            //else return false 
	}
	
	/** 
	 * This method checks to see if the char is a closed bracket
	*@param 
	*		char you are testing
	*@return
	*		It returns the boolean of this statement
	 */
    
	public boolean isClosingBracket(char c)
	{
		
		for (int i=0; i<4; i++)       //go through each item in the array closedb
		{
			if (c==closedb[i])        //if the char in question is equal to one of these brackets
			{
				return true;          //return true
			}
		}		
		return false;                 //return false
	}
	
    
    /** 
	 * This method determines it two chars correspond to one another. In otherwords, 
	*it takes two char and sees if the first one is an open bracket and then if the second 
	*char is the first one's corresponding closing brackt. It utalizes parallel arrays to 
	*complete this task. 
	*@param 
	*		two char
	*@return 
	*		boolean if they correspond 
	 */
	
	public boolean corresponds (char open, char close)
	{
		int index=-1;                         //set the index to be -1
		for (int i=0; i<4; i++)               //Go through the items in the openb array
		{
			if(open==openb[i])                //check to see if the char that was passed is one of them 
			{
				index = i;                    //if it is then save out that index into the variable index
			}
		}
		
		if (index == -1)                      //if the first for loop finished and index is still -1
		{
			return false;                      //then the char is not an openb 
		} 
		
		return (close==closedb[index]);	       //if the first for loop did return an index, then because they are
									           //parallel arrays, you can check to see if the char you passed through
									           //is the corresponding bracket in the location of index in the closedb array 
		
	}
		
    /** 
	 * This method combines all of the previous methods to see if 
	*a String has matching brackets.
	*@param
	*		a string you want to test
	*@return 
	*		int of the index where the program thinks the problem is or -1 if all match 
	*/	

	public int checkBrackets(String s)		
	{
		int length=s.length();              //get the length of the string 
		Stack stck = new Stack();            //create a new Stack called stck
		int [] index = new int [100];		//both of these are used to help keep track of where exactly the error is occuring. 
		int count = 0; 
		for (int i= 0; i<length; i++)         //loop through the string
		{
			if(isOpeningBracket(s.charAt(i)))    //if the char is an open bracket
			{
				stck.push(s.charAt(i));
				count ++; 
				index[count] = i; 		            //saves the index fo the char in the string
			}
			if(isClosingBracket(s.charAt(i)))        //if it is a closed bracket
			{
				if(corresponds(stck.peek(), s.charAt(i)))
				{
					stck.pop(); 
					index[count] = 0; 	            //if the matching closed bracket is found in the string then change the index
									               //at index 'count' and decrease the count
					count --; 
				}
				else
				{
					return i;	                     //if there is a mismatch in the brackets, let the user know at what position  (false)
				}
			}
		}
		if(stck.isEmpty())
			return -1;		                         //return -1 if the brackets all match (true)
		else
			return index[0];		                   //if there is a missing bracket somewhere return the first number in the index array
	}
		
	
	
	public static void main(String[] args)
	{
		BracketTest v  = new BracketTest(); 
		boolean isOpen = v.isOpeningBracket(']');
		System.out.println(isOpen);
		boolean isClosed = v.isClosingBracket('>');
		System.out.println(isClosed);
		boolean isCorr = v.corresponds('<','<');
		System.out.println(isCorr);
		int matched= v.checkBrackets("()[]{]");
		System.out.println(matched);
		
		
		
	}
		
}
