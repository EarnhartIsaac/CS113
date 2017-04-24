package edu.miracosta.cs113;

import myDataStructures.HashTableChain; 

/**
 * Tester class for HashTableChain. Specifically tests
 * all methods from the KWHashMap interface to make
 * sure they function correctly
 * @author w7262233
 *
 */
public class HashTableChainTester 
{	
	public static void main(String[] args)
	{
		HashTableChain<String,String> myTable = new HashTableChain<String,String>();
		
		//isEmpty test
		System.out.println("Should be true");
		System.out.println(myTable.isEmpty());
		
		//put test
		myTable.put("Isaac","Earnhart");
		myTable.put("Nery", "Chapeton-Lamas");
		myTable.put("Donald", "Trump");
		myTable.put("Hillary", "Clinton");
		myTable.put("John", "Earnhart");
		myTable.put("Chelsea", "Clinton");
		myTable.put("Ivanika", "Trump");
		myTable.put("Eric", "Trump");
		
		//toString test
		System.out.println("8 Names should be in this table\n");
		System.out.println(myTable);
		
		//put test
		System.out.println("Should output Earnhart");
		System.out.println(myTable.put("John", "Deere"));
		
		System.out.println("Should output Clinton");
		System.out.println(myTable.put("Hillary","Duff") + "\n");
		
		System.out.println("John and Hillary should have \ndifferent last names than before");
		System.out.println(myTable);
		
		//get test
		System.out.println("Names should all be apart of the table.\n3 names should be visible");
		System.out.print("Isaac ");
		System.out.println(myTable.get("Isaac"));
		
		System.out.print("Ivanika ");
		System.out.println(myTable.get("Ivanika"));
		
		System.out.print("Nery ");
		System.out.println(myTable.get("Nery"));
		
		//isEmpty test
		System.out.println("Should be false");
		System.out.println(myTable.isEmpty());
		
		//size test
		System.out.println("Should be 8");
		System.out.println(myTable.size());
		
		//remove test
		myTable.remove("Hillary");
		myTable.remove("Isaac");
		
		System.out.println("Neither Isaac nor Hillary should be in this list");
		System.out.println(myTable);
	}
}
