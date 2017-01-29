package edu.miracosta.cs113;

import java.util.Scanner;

/**
*@author Isaac Earnhart
*@version 1.0
**/

/*******************************************
* ALGORITHM
* 
* main
* CREATE keyboard
* PARSE number to check
* IF number is power of 2
* 	PRINT is power of 2
* ELSE
* 	PRINT is not power of 2
* END IF ELSE
* CLOSE keyboard
* 
* isPowerOfTwo: integer number
* DOUBLE temp is (as double)number divided by two
* IF temp minus itself as integer is not zero
* 	RETURN false
* ELSE IF temp is 1
* 	RETURN true
* ELSE
* 	RETURN isPowerOfTwo temp
* END IF ELSE
* 
********************************************/

public class Main 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter a number to check");
		String userInputStr = keyboard.nextLine();
		int userInput = Integer.parseInt(userInputStr);
		if(isPowerOfTwo(userInput))
		{
			System.out.println(userInput + " is a power of 2");
		}
		else
		{
			System.out.println(userInput + " is not a power of 2");
		}
		keyboard.close();
	}
	
	/**
	* returns true if argument number is a power of 2 else returns false
	*@param number		integer being checked 
	*@return 			if the number being checked is a power of 2
	**/
	public static boolean isPowerOfTwo(int number)
	{
		double temp = (double)number / 2;
		if (temp - (int)temp != 0)
		{
			return false;
		}
		else if(temp == 1)
		{
			return true;
		}
		else
		{
			return isPowerOfTwo((int)temp);
		}
	}
	
	
}
