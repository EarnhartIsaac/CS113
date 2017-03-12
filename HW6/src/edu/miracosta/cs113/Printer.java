package edu.miracosta.cs113;

import java.util.Iterator;
import java.util.List;

import dataStructures.ArrayQueue;

public abstract class Printer 
{
	/*****************************
	 * ****** STATIC DATA ******
	 ****************************/
	
	/**
	 * Universal timer for all the printers
	 */
	public static int currentTime = 0;
	
	public static final int DEFAULT_LOWER_BOUND = 1;
	public static final int DEFAULT_UPPER_BOUND = 2;
	public static final String DEFAULT_PRINTER_NAME = "Printer";
	
	public static final int DEFAULT_TICKS_PER_JOB = 1;
	
	/*****************************
	 * *** INSTANCE VARIABLES ***
	 ****************************/
	
	//TODO make printer speed a double and truncate for page printing

	private int ticksLeft;
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
	
	/*****************************
	 * ***** MUTATOR METHODS *****
	 ****************************/
	
	/**
	 * Sets the number of ticks left to finish a print job
	 * of so many pages
	 * @param pages the number of pages to calculate
	 */
	protected void setTicksLeft(int ticks)
	{
		this.ticksLeft = ticks;
	}
	
	protected abstract boolean resetTicks();
	
	/**
	 * Sets the lower bound to lower.
	 * lower boundary will default to DEFAULT_LOWER_BOUND
	 * if it is invalid
	 * @param lower the lower bound
	 * @return false if entered boundaries were invalid, otherwise true 
	 */
	public boolean setLowerBound(int lower)
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
	public boolean setUpperBound(int upper)
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
	
	/*****************************
	 * ***** CONSTRUCTORS *****
	 ****************************/
	
	/**
	 * Creates a printer with specific lower and upper bounds.
	 * Boundaries will default to DEFAULT_LOWER_BOUND for lower 
	 * and DEFAULT_UPPER_BOUND upper if entered boundaries are invalid
	 * @param lower the lower bound
	 * @param upper the upper bound
	 * @param name name of this printer
	 * @param speed the speed of this printer
	 */
	public Printer(int lower,int upper,String name)
	{
		this.setBoundaries(lower, upper);
		this.printerName = name;
	}
	
	public Printer(int lower,int upper)
	{
		this(lower,upper,DEFAULT_PRINTER_NAME);
	}
	
	public Printer()
	{
		this(DEFAULT_LOWER_BOUND,
				DEFAULT_UPPER_BOUND);
	}

	/*****************************
	 * ***** OTHER METHODS *****
	 ****************************/
	
	/**
	 * Returns a reference to the current job being printed
	 * @return job reference
	 */
	public PrintJob getCurrentJob()
	{
		return this.currentJob;
	}
	
	public boolean isPrinting()
	{
		return this.currentJob != null;
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
			
			//TODO Remove output method
			//*****************************************************
			System.out.println(item + " added to queue for " + this.printerName + 
								" at minute " + currentTime);
			//*****************************************************
			
			return true;
		}
		return false;
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
			--this.ticksLeft;
			if(this.ticksLeft == 0)
			{
				//TODO Remove output method
				//*****************************************************
				System.out.println(this.currentJob + " finished on " + this.printerName + 
									" at minute " + currentTime);
				//*****************************************************
				
				this.currentJob.finish();
				this.currentJob = printQueue.poll();
				this.resetTicks();
			}
		}
		else
		{
			this.currentJob = printQueue.poll();
			if(currentJob != null)
			{
				this.resetTicks();
			}
		}
	}
	
	/**
	 * Returns the data from this instance in the form
	 * <printer name> current job: <current job name>
	 * @return string representing data in this instance
	 */
	public String toString()
	{
		return this.printerName + "current job:  " + this.currentJob;
	}
	
	/*****************************
	 * ***** STATIC METHODS *****
	 ****************************/
	
	//TODO give incrementTime other features 
	/**
	 * Increments the universal counter for the printers
	 * @return the current time after time increment
	 */
	private static int incrementTime()
	{
		return ++currentTime;
	}
	
	/**
	 * Ticks all printers in the printers array
	 * @param printers array of printers to tick
	 * @param numberUsed number of spaces used in printers array
	 * @return false if printers is null
	 */
	public static boolean syncronizedTick(Printer[] printers,int numberUsed)
	{
		if(printers != null)
		{
			for(int counter = 0;counter<numberUsed;counter++)
			{
				printers[counter].tick();
			}
			incrementTime();
			return true;
		}
		return false;
	}
	
	/**
	 * Ticks all printers in the printers list
	 * @param printers list of printers to tick
	 * @return false if printers is null
	 */
	public static boolean syncronizedTick(List<Printer> printers)
	{
		if(printers != null)
		{
			Iterator<Printer> itr = printers.iterator();
			while(itr.hasNext())
			{
				itr.next().tick();
			}
			incrementTime();
			return true;
		}
		return false;
	}
	
}
