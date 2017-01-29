package edu.miracosta.cs113;

import java.util.Scanner;

public class Main 
{
	/**
	 * Tester for optimized theory checker
	 * 
	 * @param args
	 *            command line arguments (unnused)
	 */
	public static void main(String[] args) 
	{
		int answerSet, solution, murder, weapon, location;
		Scanner keyboard = new Scanner(System.in);
		Theory answer = null;
		AssistantJack jack;

		System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
		answerSet = keyboard.nextInt();
		keyboard.close();

		jack = new AssistantJack(answerSet);

		murder = 1;
		location = 1;
		weapon = 1;
		
		boolean solved = false;
		
		do 
		{
			solution = jack.checkAnswer(weapon, location, murder);
			switch(solution)
			{
				case 1:
					weapon++;
					break;
				case 2:
					location++;
					break;
				case 3:
					murder++;
					break;
				case 0:
					solved = true;
					break;
			}
		} while (!solved);
		answer = new Theory(weapon, location, murder);
		System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution = " + answer);

		if (jack.getTimesAsked() > 20) {
			System.out.println("FAILED!! You're a horrible Detective...");
		} else {
			System.out.println("WOW! You might as well be called Batman!");
		}

	}
}
