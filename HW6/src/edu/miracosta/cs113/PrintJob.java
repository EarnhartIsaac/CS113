package edu.miracosta.cs113;

//Letting the Printer set the number of minutes to completion to allow for Printer to change speed in future
public class PrintJob 
{
	public static final String DEFAULT_TITLE = "Print job";
	
	private String printTitle;
	private int numberOfPages;
	private boolean isFinished;
	
	public PrintJob(String title,int size)
	{
		this.printTitle = title;
		this.numberOfPages = size;
		this.isFinished = false;
	}
	
	protected void finish()
	{
		this.isFinished = true;
	}
	
	public int getNumberOfPages()
	{
		return this.numberOfPages;
	}
	
	public boolean isFinished()
	{
		return this.isFinished;
	}
	
	public String toString()
	{
		return this.printTitle;
	}
}
