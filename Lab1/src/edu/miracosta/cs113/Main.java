package edu.miracosta.cs113;

public class Main 
{
	public static void main(String[] args)
	{
		for(int counter = 1;counter < 101;counter++)
		{
			boolean multipleOf3 = (counter%3 == 0);
			boolean multipleOf5 = (counter%5 == 0);
			
			if(multipleOf3 && multipleOf5)
			{
				System.out.println("Fizzbuzz");
			}
			else if(multipleOf3)
			{
				System.out.println("Fizz");
			}
			else if(multipleOf5)
			{
				System.out.println("Buzz");
			}
			else
			{
				System.out.println(counter);
			}
		}
	}
}
