package edu.miracosta.cs113;

/*******************************************
* ALGOORITHM
* FOR counter 1 to 100
* 	BOOLEAN multipleOf3 is counter modulo 3
* 	BOOLEAN multipleOf5 is counter modulo 5
* 	
* 	IF multipleOf3 and multipleOf5
* 		PRINT Fizzbuzz
* 	ELSE IF multipleOf3
* 		PRINT Fizz
* 	ELSE IF multipleOf5 
* 		PRINT Buzz
* 	ELSE
* 		PRINT counter
* 	END IF ELSE
* END FOR
********************************************/

/**
*@author Isaac Earnhart
*@version 1.0
**/
public class Main 
{
	public static void main(String[] args)
	{
		boolean multipleOf3;
		boolean multipleOf5;
		
		for(int counter = 1;counter < 101;counter++)
		{
			multipleOf3 = (counter%3 == 0);
			multipleOf5 = (counter%5 == 0);
			
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
