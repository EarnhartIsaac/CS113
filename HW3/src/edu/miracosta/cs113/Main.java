package edu.miracosta.cs113;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		LinkedList<Term> polynomial1 = new LinkedList<Term>();
		LinkedList<Term> polynomial2 = new LinkedList<Term>();
		
		boolean adding = true;
		String userInput;
		
		int coefficient;
		int exponent;
		
		while(adding)
		{
			System.out.println("Polynomial 1");
			System.out.println("Would you like to add a Term?(Y/N)");
			userInput = keyboard.nextLine();
			if(userInput != null)
			{
				switch(userInput.charAt(0))
				{
					case 'Y':
					case 'y':
						System.out.println("Please enter the coefficient of this new term");
						userInput = keyboard.nextLine();
						coefficient = Integer.parseInt(userInput);
						
						System.out.println("Please enter the exponent of this new term");
						userInput = keyboard.nextLine();
						exponent = Integer.parseInt(userInput);
						
						polynomial1.add(new Term(coefficient,exponent));
						break;
					default:
						adding = false;
						break;	
				}
			}
			else
			{
				adding = false;
			}
		}
		
		adding = true;
		
		while(adding)
		{
			System.out.println("Polynomial 2");
			System.out.println("Would you like to add a Term?(Y/N)");
			userInput = keyboard.nextLine();
			if(userInput != null)
			{
				switch(userInput.charAt(0))
				{
					case 'Y':
					case 'y':
						System.out.println("Please enter the coefficient of this new term");
						userInput = keyboard.nextLine();
						coefficient = Integer.parseInt(userInput);
						
						System.out.println("Please enter the exponent of this new term");
						userInput = keyboard.nextLine();
						exponent = Integer.parseInt(userInput);
						
						polynomial2.add(new Term(coefficient,exponent));
						break;
					default:
						adding = false;
						break;	
				}
			}
			else
			{
				adding = false;
			}
		}
		
		System.out.println("Added polynomial");
		LinkedList<Term> temp = PolynomialAdder.addPolynomials(polynomial1.iterator(), polynomial2.iterator());
		Iterator<Term> tempIterator = temp.iterator();
		while(tempIterator.hasNext())
		{
			System.out.println(tempIterator.next());
		}
	}
}
