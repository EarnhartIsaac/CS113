package drivers;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class Driver212 
{
	public static void delete(ArrayList<String> aList,String target)
	{
		aList.remove(aList.indexOf(target));
	}
	
	//TODO have this test a correct copy of the right answer
	public static void testDelete(ArrayList<String> aList,String target)
	{
		int size = aList.size();
		delete(aList,target);
		Assert.assertTrue(aList.size() == size-1);
	}
	
	@Test
	public void testDelete1()
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("Hello, ");
		list.add("This");
		list.add("sentence");
		list.add("automatic rifle");
		list.add("should make");
		list.add("sense");
		testDelete(list,"automatic rifle");
	}
	
	@Test
	public void testDelete2()
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("This");
		list.add("This");
		list.add("Not This");
		list.add("This");
		list.add("This");
		testDelete(list,"This");
	}
}
