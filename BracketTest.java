/**
This is for part e. See comments in part a for the things that aren't commented here
*/

public class BracketTest		
{
	
	public char[] openb = {'(','[' , '{' , '<'}; 	
	public char[] closedb = {')' ,']' ,'}' ,'>'}; 
	
	public boolean isOpeningBracket(char c)
	{
		
		for (int i=0; i<4; i++)
		{
			if (c==openb[i])
			{
				return true; 
			}
		}		
		return false;
	}
	
	
	public boolean isClosingBracket(char c)
	{
		
		for (int i=0; i<4; i++)
		{
			if (c==closedb[i])
			{
				return true; 
			}
		}		
		return false;
	}
	
	
	public boolean corresponds (char open, char close)
	{
		int index=-1; 
		for (int i=0; i<4; i++)
		{
			if(open==openb[i])
			{
				index = i;
			}
		}
		
		if (index == -1)
		{
			return false;
		}
		
		return (close==closedb[index]);	
		
	}
		
	
/**
The main changes in the code occured in this method	
*/
	public int checkBrackets(String s)		
	{
		int length=s.length();
		Stack stck = new Stack();
		int [] index = new int [100];		//both of these are used to help keep track of where exactly the error is occuring. 
		int count = 0; 
		for (int i= 0; i<length; i++)
		{
			if(isOpeningBracket(s.charAt(i)))
			{
				stck.push(s.charAt(i));
				count ++; 
				index[count] = i; 		//saves the index fo the char in the string
			}
			if(isClosingBracket(s.charAt(i)))
			{
				if(corresponds(stck.peek(), s.charAt(i)))
				{
					stck.pop(); 
					index[count] = 0; 	//if the matching closed bracket is found in the string then change the index
									//at index 'count' and decrease the count
					count --; 
				}
				else
				{
					return i;	//if there is a mismatch in the brackets, let the user know at what position  (false)
				}
			}
		}
		if(stck.isEmpty())
			return -1;		//return -1 if the brackets all match (true)
		else
			return index[0];		//if there is a missing bracket somewhere return the first number in the index array
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
