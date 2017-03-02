package edu.miracosta.cs113;

import java.util.Scanner;
import userInput.Cs113;
import dataStructures.ArrayStack;
import dataStructures.LinkedListStack;
import dataStructures.Stack;

//TODO convert to lower case when pushing data to the stack rather than with toLowerCase to increase efficiency

/*********************
 * **** ALGORITHM ****
 * *******************
 * VARIABLES
 * isPalindrome boolean starts as true
 * Stack1: Characters
 * Stack2: Characters
 * String of invalid characters
 * counter1 for stack1 starts at 0
 * counter2 for stack2 starts at last char in the user input (userInputStr.length() - 1)
 * 
 * WHILE counter1 is less than counter2
 * 		IF userInputString character at counter1 is not a valid char
 * 			counter1 increments
 * 		END IF
 * 		Stack1 push userInputStr character at counter1
 * 		counter1 increments
 * 
 * 		IF userInputString character at counter2 is not a valid char
 * 			counter2 decrements
 * 		END IF
 * 		Stack2 push userInputStr character at counter2
 * 		counter2 decrements
 * END WHILE
 * (Both stacks will have 1 extra term if even or the same last term if odd)
 * 
 * (Stack1 will always be the same size as Stack2)
 * WHILE stack1 is not empty
 * 		IF stack1 pop is not equal to stack2 pop
 * 			isPalindrome is false
 * 		END IF
 * END WHILE
 * 
 * Value of isPalindrome should now indicate if the user input was a palindrome
 */

/**
 * Palindrome solver takes user inputed strings and checks to see if they are palindromes.
 * The program converts the string to lower case and ignores symbols and white space when
 * checking if the string i s a palindrome.
 * @author W7262233
 * @since 02/28/2017
 */
public class PalindromSolver 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		Stack<Character> palStack1 = new ArrayStack<Character>();
		Stack<Character> palStack2 = new LinkedListStack<Character>();
		
		String userInput = Cs113.readString("Please enter a word or phrase to be checked",keyboard); 
		String userInputStr = userInput.toLowerCase();

		int counter1 = 0;
		int counter2 = userInputStr.length() - 1;
		
		String invalidChar = " \n\t!@#$%^&*()_+=-`~{}[]|\'\";:/?.>,<";
		
		//Enables both stacks to grab the same amount of objects
		//stacks will end up grabbing one extra item each
		while(counter1 < counter2)
		{
			while(invalidChar.indexOf(userInputStr.charAt(counter1)) != -1)
			{
				counter1++;
			}
			palStack1.push(userInputStr.charAt(counter1));
			counter1++;
			
			while(invalidChar.indexOf(userInputStr.charAt(counter2)) != -1)
			{
				counter2--;
			}
			palStack2.push(userInputStr.charAt(counter2));
			counter2--;
		}
		
		boolean isPalindrome = true;
		
		while(!palStack1.isEmpty())
		{
			if(!palStack1.pop().equals(palStack2.pop()))
			{
				isPalindrome = false;
			}
		}
		
		if(isPalindrome)
		{
			System.out.println(userInputStr + " is a palindrome");
		}
		else
		{
			System.out.println(userInputStr + " is not a palindrome");
		}
	}
}
