package givenFiles;

public class DirectoryEntry 
{
	private String name;
	private String number;
	
	public String getNumber()
	{
		return number;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setNumber(String number)
	{
		this.number = number;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public DirectoryEntry(String name,String number)
	{
		this.setName(name);
		this.setNumber(number);
	}
	
	public boolean equals(Object o)
	{
		if(o != null)
		{
			DirectoryEntry entry = (DirectoryEntry)o;
			return entry.getName().equals(this.getName());	
		}
		return false;
	}
}
