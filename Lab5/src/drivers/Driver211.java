package drivers;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class Driver211 
{	
	public static void replace(ArrayList<String> aList,
									String oldItem,
									String newItem)
	{
		int position = aList.indexOf(oldItem);;
		while (position != -1)
		{
			aList.set(position,newItem);
			position = aList.indexOf(oldItem);
		}
	}
	
	//TODO make this test method check for exact copy of correct list
	public static void testReplace(ArrayList<String> aList,
									String oldItem,
									String newItem)
	{
		replace(aList,oldItem,newItem);
		Assert.assertTrue(aList.indexOf(oldItem) == -1);
	}
	
	@Test
	public void testReplace1()
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("Harry");
		list.add("Larry");
		list.add("Megan");
		list.add("Larry");
		list.add("George");
		list.add("Mom");
		testReplace(list,"Larry","Mom");
	}
	
	@Test
	public void testReplace2()
	{
		ArrayList<String> list = new ArrayList<String>();
		testReplace(list,"Larry","Mom");
	}
	
	@Test
	public void testReplace3()
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("Larry");
		list.add("Larry");
		list.add("Larry");
		list.add("Larry");
		list.add("Larry");
		testReplace(list,"Larry","Mom");
	}
}
