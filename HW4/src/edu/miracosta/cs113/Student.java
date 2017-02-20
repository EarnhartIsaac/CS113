package edu.miracosta.cs113;

public class Student 
{
	private String name;
	private String iDNumber;
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setIDNumber(String iDNumber)
	{
		this.iDNumber = iDNumber;
	}
	
	public Student(String name,String iDNumber)
	{
		this.setName(name);
		this.setIDNumber(iDNumber);
	}
	
	public Student(String name)
	{
		this.setName(name);
		this.setIDNumber("Not assigned");
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getIDNumber()
	{
		return this.iDNumber;
	}
	
	public boolean equals(Object object)
	{
		if(object != null)
		{
			Student temp = (Student)object;
			return this.name.equals(temp.getName());
		}
		return false;
	}
	
	public String toString()
	{
		return this.name;
	}
}
