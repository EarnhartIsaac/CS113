package edu.miracosta.cs113;

import dataStructures.ArrayQueue;

public class Printer 
{
	/**
	 * Universal timer for all the printers
	 */
	public static int currentTime = 0;
	
	public static final int DEFAULT_LOWER_BOUND = 1;
	public static final int DEFAULT_UPPER_BOUND = 2;
	public static final String DEFAULT_PRINTER_NAME = "Printer";
	/**
	 * Speed is defined as pages per tap
	 */
	public static final int DEFAULT_SPEED = 1;
	
	
	private int printerSpeed;
	private int tapsLeft;
	private String printerName;
	
	/**
	 * Queue for printer jobs
	 */
	private ArrayQueue<PrintJob> printQueue = new ArrayQueue<PrintJob>();
	
	/**
	 * Reference to the current print job being printed. 
	 * Is null if there is nothing being printed
	 */
	private PrintJob currentJob;
	
	/**
	 * Lower Boundary for the number of pages this printer
	 * will accept for a print job. 
	 * This lower boundary is inclusive
	 */
	private int lowerBound;
	
	/**
	 * Upper Boundary for the number of pages this printer
	 * will accept for a print job. 
	 * This upper boundary is exclusive
	 */
	private int upperBound;
	
	/**
	 * Sets the lower bound to lower.
	 * lower boundary will default to DEFAULT_LOWER_BOUND
	 * if it is invalid
	 * @param lower the lower bound
	 * @return false if entered boundaries were invalid, otherwise true 
	 */
	private boolean setLowerBound(int lower)
	{
		if(lower <= 0)
		{
			this.lowerBound = DEFAULT_LOWER_BOUND;
			return false;
		}
		this.lowerBound = lower;
		return true;
	}
	
	/**
	 * Sets the upper bound to upper.
	 * Upper boundary will default to DEFAULT_UPPER_BOUND
	 * if it is invalid
	 * @param upper the upper bound
	 * @return false if entered boundaries were invalid, otherwise true 
	 */
	private boolean setUpperBound(int upper)
	{
		if(upper <= 1)
		{
			this.upperBound = DEFAULT_UPPER_BOUND;
			return false;
		}
		this.upperBound = upper;
		return true;
	}
	
	/**
	 * Sets the boundaries for this instance of Printer.
	 * Boundaries will default to DEFAULT_LOWER_BOUND for lower 
	 * and DEFAULT_UPPER_BOUND upper if entered boundaries are invalid
	 * @param lower the lower bound
	 * @param upper the upper bound
	 * @return false if entered boundaries were invalid, otherwise true
	 */
	public boolean setBoundaries(int lower,int upper)
	{
		if(lower < upper)
		{
			this.setLowerBound(lower);
			this.setUpperBound(upper);
			return true;
		}
		this.setLowerBound(DEFAULT_LOWER_BOUND);
		this.setLowerBound(DEFAULT_UPPER_BOUND);
		return false;
	}
	
	
	/**
	 * Creates a printer with specific lower and upper bounds.
	 * Boundaries will default to DEFAULT_LOWER_BOUND for lower 
	 * and DEFAULT_UPPER_BOUND upper if entered boundaries are invalid
	 * @param lower the lower bound
	 * @param upper the upper bound
	 */
	public Printer(int lower,int upper,String name)
	{
		this.setBoundaries(lower, upper);
		this.printerName = name;
		this.printerSpeed = DEFAULT_SPEED;
	}
	
	public Printer(int lower,int upper)
	{
		this(lower,upper,DEFAULT_PRINTER_NAME);
	}

	/**
	 * Adds a print job the queue.
	 * If the given print job is not
	 * within the page boundaries it is not added
	 * @param item PrintJob being added
	 * @return false if the job was not added due to out of bounds size
	 */
	public boolean addPrintJob(PrintJob item)
	{
		if(inBounds(item))
		{
			this.printQueue.offer(item);
			return true;
		}
		return false;
	}
	
	
	private int tap()
	{
		return --this.tapsLeft;
	}
	
	/**
	 * Checks to see if a PrintJob is valid for this printer
	 * @param item the PrintJob to check
	 * @return returns false if PrintJob is out of size bounds, true if not
	 */
	public boolean inBounds(PrintJob item)
	{
		if(item != null)
		{
			return item.getNumberOfPages() < upperBound && 
					item.getNumberOfPages() >= lowerBound;
		}
		return false;
	}
	
	/**
	 * Increments the time going by for this printer.
	 * If the printer is not printing anything then a
	 * new job is polled from the queue. A new job is also
	 * polled if a job finishes after this tick
	 */
	public void tick()
	{
		if(currentJob != null)
		{
			this.tap();
			
			if(this.tapsLeft == 0)
			{
				this.currentJob.finish();
				this.currentJob = printQueue.poll();
			}
		}
		else
		{
			this.currentJob = printQueue.poll();
		}
	}
	
	private void calculateTapsLeft(int pages)
	{
		this.tapsLeft = pages * printerSpeed;
	}
	
	/**
	 * Increments the universal counter for the printers
	 * @return the current time after time increment
	 */
	public static int incrementTime()
	{
		return ++currentTime;
	}
	
	public String toString()
	{
		return this.printerName + "current job:  " + this.currentJob;
	}
	
}
