package edu.miracosta.cs113;

import java.util.Scanner;

/*******************************************
* ALGORITHM
* 
* murder is 1
* weapon is 1
* location is 1
* 
* BOOLEAN solved is false
* 
* DO
* 	solution is AssistantJack check weapon,location,murder
* 	SWITCH solution
* 		CASE 1
* 			ADD 1 to weapon
* 		CASE 2
* 			ADD 1 to location
* 		CASE 3 
* 			ADD 1 to murder
* 		CASE 0
* 			solved is true
* 	END SWITCH
* WHILE not solved
********************************************/

/**
 * 
 * @author Isaac Earnhart
 * 
 */
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
