package driver;


public class Combination
{
	private int quarters;
	private int dimes;
	private int nickles;
	private int pennies;
	
	public Combination(int quarters,
						int dimes,
						int nickles,
						int pennies)
	{
		this.quarters = quarters;
		this.dimes = dimes;
		this.nickles = nickles;
		this.pennies = pennies;
	}
	
	public boolean equals(Object object)
	{
		if(object != null)
		{
			Combination combo = (Combination)object;
			return this.quarters == combo.quarters && 
					this.dimes == combo.dimes &&
					this.nickles == combo.nickles &&
					this.pennies == combo.pennies;
					
		}
		return false;
	}
}
