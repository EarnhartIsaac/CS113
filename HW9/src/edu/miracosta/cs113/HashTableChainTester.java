package edu.miracosta.cs113;

import myDataStructures.HashTableChain; 

public class HashTableChainTester 
{	
	public static void main(String[] args)
	{
		HashTableChain<String,String> myTable = new HashTableChain<String,String>();
		
		myTable.put("Isaac","Earnhart");
		myTable.put("Nery", "Chapeton-Lamas");
		myTable.put("Donald", "Trump");
		myTable.put("Hillary", "Clinton");
		myTable.put("John", "Earnhart");
		myTable.put("Chelsea", "Clinton");
		myTable.put("Ivanika", "Trump");
		myTable.put("Eric", "Trump");
		
		System.out.println("8 Names should be in this table\n");
		System.out.println(myTable);
		
		System.out.println("Should output Earnhart");
		System.out.println(myTable.put("John", "Deere"));
		
		System.out.println("Should output Clinton");
		System.out.println(myTable.put("Hillary","Duff") + "\n");
		
		System.out.println("John and Hillary should have \ndifferent last names than before");
		System.out.println(myTable);
		
		System.out.println("Names should all be apart of the table.\n3 names should be visible");
		System.out.print("Isaac ");
		System.out.println(myTable.get("Isaac"));
		
		System.out.print("Ivanika ");
		System.out.println(myTable.get("Ivanika"));
		
		System.out.print("Nery ");
		System.out.println(myTable.get("Nery"));
		
		System.out.println("Should be false");
		System.out.println(myTable.isEmpty());
		
		
		
	}
}
