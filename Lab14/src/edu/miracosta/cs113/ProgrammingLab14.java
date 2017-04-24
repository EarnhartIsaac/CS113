package edu.miracosta.cs113;

public class ProgrammingLab14 
{
	/**************************
	 * ****NOTE TO NERY****
	 * what happens if we remove an entry that previously
	 * was blocking another, forcing it into a position
	 * other than its hash % length. Then we would find null
	 * and return as if the object was not found.
	 * 
	 * I followed the algorithm from the book. 
	 * Maybe I'm missing something but that doesn't seem correct
	 **************************/
	
	/**
	 * finds the index of a given object
	 * @param object the object to search for
	 * @param table table to search in
	 * @return index, -1 if object not found
	 */
	public static int findLocation(Object object,Object[] table)
	{
		int index = object.hashCode() % table.length;
		if(index < 0)
		{
			index = index + table.length;
		}
		if(table[index] == null)
		{
			return -1;
		}
		else if(table[index].equals(object))
		{
			return index;
		}
		else
		{
			//Increment index, then check to see if index is null
			while(table[++index] != null)
			{
				if(table[index].equals(object))
				{
					return index;
				}
			}
			return -1;
		}
	}
}
