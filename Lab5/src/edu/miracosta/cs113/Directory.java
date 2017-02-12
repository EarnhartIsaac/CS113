package edu.miracosta.cs113;

import givenFiles.DirectoryEntry;
import java.util.ArrayList;

public class Directory 
{
	ArrayList<DirectoryEntry> theDirectory = new ArrayList<DirectoryEntry>();
	
	
	//SEE BOOK PG 71 FOR DOCUMENTATION
	public String addOrChangeEntry(String aName,String newNumber)
	{
		DirectoryEntry temp = new DirectoryEntry(aName,newNumber);
		int position = theDirectory.indexOf(temp);
		if(position != -1)
		{
			String oldNumber = theDirectory.get(position).getNumber();
			theDirectory.set(position, temp);
			return oldNumber;
		}
		else
		{
			theDirectory.add(temp);
			return null;
		}
	}
	
	//SEE BOOK PG 71 FOR DOCUMENTATION
	public DirectoryEntry removeEntry(String aName)
	{
		int position = theDirectory.indexOf(new DirectoryEntry(aName,"N/A"));
		if(position != -1)
		{
			DirectoryEntry oldEntry = theDirectory.get(position);
			theDirectory.remove(position);
			return oldEntry;
		}
		return null;
	}
}
