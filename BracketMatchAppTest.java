/** 
* This class is the main function which utalizes the BracketTest class
*to accomplish the task of determing whether the string the user 
*passes through in the terminal, does in fact have matching brackets
*/

import java.util.Scanner;                                   //allows us to scan for a users answer the in terminal

public class BracketMatchAppTest
{
	public static void main(String args[]) 
	{
		Scanner s = new Scanner(System.in);                //creates a scanner variable s
        
		System.out.println("please input your string");   //prints out the instructions to the user
        
		String in=s.next();                               //saves their response as a string variable called in for input
        
		BracketTest errorfinder  = new BracketTest();  	  //creates a new BracketTest called errorfinder
        
		int result = errorfinder.checkBrackets(in);       //checks to see if the brackets match in the string the user typed in the command line
        
		if (result ==-1)
		{
            
			System.out.println("Your input has matching brackets"); 
            
		}
		else
		{
            
            //let the user know where their error is and what is in that position 
            
			System.out.println("Error: '"+in.charAt(result)+ "' at position "+ result);	
			
		}
	}
}