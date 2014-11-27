/**
This is for part e. See comments in part a for the things that aren't commented here
*/

import java.util.Scanner;

public class BracketMatchAppTest
{
	public static void main(String args[]) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("please input your string");
		String in=s.next();
		BracketTest errorfinder  = new BracketTest();  		//changed this line for part e
		int result = errorfinder.checkBrackets(in);
		if (result ==-1)
		{
			System.out.println("Your input has matching brackets"); 
		}
		else
		{
			System.out.println("Error: '"+in.charAt(result)+ "' at position "+ result);	//let the user know where their error is and what is in that position 
			
		}
	}
}
