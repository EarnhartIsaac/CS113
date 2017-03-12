package edu.miracosta.cs113;

public class BasicPrinter extends Printer
{
	public static final int DEFAULT_TICKS_PER_JOB = 1;
	
	/**
	 * number of ticks it takes to finish one print job
	 * on this printer
	 */
	private int ticksPerJob;
	
	public BasicPrinter(int lower,int upper,String name,int ticksPerJob)
	{
		super(lower,upper,name);
		this.ticksPerJob = ticksPerJob;
	}
	
	public BasicPrinter()
	{
		super();
		this.ticksPerJob = DEFAULT_TICKS_PER_JOB;
	}
	
	public boolean resetTicks()
	{
		if(this.getCurrentJob() != null)
		{
			this.setTicksLeft(ticksPerJob);
			return true;
		}
		return false;
	}
}
