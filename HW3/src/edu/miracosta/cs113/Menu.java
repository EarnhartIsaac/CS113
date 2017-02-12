package edu.miracosta.cs113;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * TODO TURN THIS INTO ITS OWN LIST IN THE FUTURE
 * TODO Add with menu option as inner class and make as a package
 */

public class Menu 
{
	private ArrayList<MenuOption> options  = new ArrayList<MenuOption>();
	private Scanner keyboard = new Scanner(System.in);
	
	public ArrayList<MenuOption> getOptions()
	{
		return this.options;
	}
	
	public char printMenu()
	{
		Iterator<MenuOption> optionsIterator = options.iterator();
		MenuOption temp;
		String userInputStr;
		char userInput;
		
		while(optionsIterator.hasNext())
		{
			temp = optionsIterator.next();
			System.out.println(temp.getKeyBind() + ") " + temp.getOptionName());
		}
		userInputStr = keyboard.nextLine();
		userInput = userInputStr.charAt(0);
		
		return userInput;
		
		/*
		//Checking to make sure this is a valid option
		optionsIterator = options.iterator();
		
		while(optionsIterator.hasNext())
		{
			temp = optionsIterator.next();
			if(temp.getKeyBind() == userInput)
			{
				return userInput;
			}
		}
		return '\n';
		*/
	}
}
