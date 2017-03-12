package edu.miracosta.cs113;

public class AdvancedPrinter extends Printer
{
	/**
	 * Speed is defined as pages per tap
	 */
	public static final int DEFAULT_SPEED = 10;
	
	private int printerSpeed;
	
	public AdvancedPrinter(int lower,int upper,String name,int speed)
	{
		super(lower,upper,name);
		this.printerSpeed = speed;
	}
	
	public AdvancedPrinter()
	{
		super();
		this.printerSpeed = DEFAULT_SPEED;
	}
	
	/**
	 * Sets the number of ticks left to finish a print job
	 * of so many pages. 
	 */
	protected boolean resetTicks()
	{
		if(this.getCurrentJob() != null)
		{
			this.setTicksLeft(this.getCurrentJob().getNumberOfPages() * printerSpeed);
			return true;
		}
		return false;
	}
}
