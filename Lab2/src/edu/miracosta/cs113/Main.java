package edu.miracosta.cs113;

import java.util.Scanner;

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
