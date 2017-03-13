package driver;

public class Change 
{
	public static final int[] COIN_VALUES = new int[]{25,10,5,1};
	
	public static int combinationCount = 0;
	
	public static void main(String[] args)
	{
		calculateChange(5);
		combinationCount = 0;
		calculateChange(10);
		combinationCount = 0;
		calculateChange(15);
		combinationCount = 0;
		calculateChange(20);
		combinationCount = 0;
		calculateChange(25);
		combinationCount = 0;
		calculateChange(30);
		combinationCount = 0;
		calculateChange(75);
	}
	
	//public static test
	
	public static void calculateChange(int change)
	{
		getChange(change,0,0,0,0,0);
	}
	
	//SO MANY ACTIVATION FRAMES
	public static void getChange(int changeLeft,
							int quarters,
							int dimes,
							int nickles,
							int pennies,
							int maxCoin)
	{
		if(changeLeft >= 25 && COIN_VALUES[maxCoin] >= 25)
		{
			getChange(changeLeft - 25,
					quarters + 1,
					dimes,
					nickles,
					pennies,
					0);
		}
		if(changeLeft >= 10 && COIN_VALUES[maxCoin] >= 10)
		{
			getChange(changeLeft - 10,
					quarters,
					dimes + 1,
					nickles,
					pennies,
					1);
		}
		if(changeLeft >= 5 && COIN_VALUES[maxCoin] >= 5)
		{
			getChange(changeLeft - 5,
					quarters,
					dimes,
					nickles + 1,
					pennies,
					2);
		}
		if(changeLeft >= 1 && COIN_VALUES[maxCoin] >= 1)
		{
			getChange(changeLeft - 1,
					quarters,
					dimes,
					nickles,
					pennies + 1,
					3);
		}
		if(changeLeft == 0)
		{
			System.out.println("****************************");
			System.out.println("Combination: " + ++combinationCount);
			System.out.println("Quarters: " + quarters);
			System.out.println("Dimes: " + dimes);
			System.out.println("Nickles: " + nickles);
			System.out.println("Pennies: " + pennies);
		}
	}
}
