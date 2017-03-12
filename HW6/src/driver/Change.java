package driver;

import java.util.ArrayList;
import java.util.List;

public class Change 
{
	public static int combinationCount = 0;
	public static List<Combination> combinations = new ArrayList<Combination>();
	
	public static void main(String[] args)
	{
		calculateChange(5);
		combinationCount = 0;
		combinations = new ArrayList<Combination>();
		calculateChange(10);
		combinationCount = 0;
		combinations = new ArrayList<Combination>();
		calculateChange(15);
		combinationCount = 0;
		combinations = new ArrayList<Combination>();
		calculateChange(20);
		combinationCount = 0;
		combinations = new ArrayList<Combination>();
		calculateChange(25);
		combinationCount = 0;
		combinations = new ArrayList<Combination>();
		calculateChange(30);
		combinationCount = 0;
		combinations = new ArrayList<Combination>();
		calculateChange(75);
	}
	
	//public static test
	
	public static void calculateChange(int change)
	{
		getChange(change,0,0,0,0);
	}
	
	//SO MANY ACTIVATION FRAMES
	public static void getChange(int changeLeft,
							int quarters,
							int dimes,
							int nickles,
							int pennies)
	{
		if(changeLeft >= 25)
		{
			getChange(changeLeft - 25,
					quarters + 1,
					dimes,
					nickles,
					pennies);
		}
		if(changeLeft >= 10)
		{
			getChange(changeLeft - 10,
					quarters,
					dimes + 1,
					nickles,
					pennies);
		}
		if(changeLeft >= 5 )
		{
			getChange(changeLeft - 5,
					quarters,
					dimes,
					nickles + 1,
					pennies);
		}
		if(changeLeft >= 1)
		{
			getChange(changeLeft - 1,
					quarters,
					dimes,
					nickles,
					pennies + 1);
		}
		if(changeLeft == 0)
		{
			//It takes forever to compute but IT WORKS, NO DUPLICATIONS
			//not sure how to avoid duplications algorithmically without hogging stupid amounts of memory
			//but if I could runtime wouldn't be piss poor
			if(combinations.indexOf(new Combination(quarters,dimes,nickles,pennies)) == -1)
			{
				combinations.add(new Combination(quarters,dimes,nickles,pennies));
				System.out.println("****************************");
				System.out.println("Combination: " + ++combinationCount);
				System.out.println("Quarters: " + quarters);
				System.out.println("Dimes: " + dimes);
				System.out.println("Nickles: " + nickles);
				System.out.println("Pennies: " + pennies);
			}
		}
	}
}
