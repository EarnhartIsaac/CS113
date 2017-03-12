package edu.miracosta.cs113;

public class PrintJob 
{
	/*****************************
	 * ****** STATIC DATA ******
	 ****************************/
	
	public static final String DEFAULT_TITLE = "Print job";
	
	/*****************************
	 * *** INSTANCE VARIABLES ***
	 ****************************/
	
	private String printTitle;
	private int numberOfPages;
	private boolean isFinished;
	
	/*****************************
	 * ****** CONSTRUCTORS ******
	 ****************************/
	
	/**
	 * Creates a print job with a name and page count
	 * @param title name of print job
	 * @param size page count
	 */
	public PrintJob(String title,int size)
	{
		this.printTitle = title;
		this.numberOfPages = size;
		this.isFinished = false;
	}
	
	public PrintJob(int size)
	{
		this(DEFAULT_TITLE,size);
	}
	
	/*****************************
	 * *** MUTATOR METHODS ***
	 ****************************/
	
	/**
	 * Sets isFinished to true;
	 */
	protected void finish()
	{
		this.isFinished = true;
	}
	
	/*****************************
	 * *** ACCESSOR METHODS ***
	 ****************************/
	
	/**
	 * Gets the number of pages this print job is
	 * @return number of pages
	 */
	public int getNumberOfPages()
	{
		return this.numberOfPages;
	}
	
	/**
	 * Checks to see if this print job is finished
	 * @return true if PrintJob is finished, false if not
	 */
	public boolean isFinished()
	{
		return this.isFinished;
	}
	
	public String toString()
	{
		return this.printTitle;
	}
}
