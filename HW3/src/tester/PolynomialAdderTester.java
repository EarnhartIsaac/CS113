package tester;

import org.junit.Assert;
import org.junit.Test;

import edu.miracosta.cs113.Iterator;
import edu.miracosta.cs113.LinkedList;
import edu.miracosta.cs113.PolynomialAdder;
import edu.miracosta.cs113.Term;

public class PolynomialAdderTester 
{
	/*
	public static void main(String[] args)
	{
		
	}
	*/
	
	public void testPolyAddition(LinkedList<Term> result,Iterator<Term> firstPolynomial,
			Iterator<Term> secondPolynomial)
	{
		Assert.assertTrue(result.equals(
						PolynomialAdder.addPolynomials(
						firstPolynomial, 
						secondPolynomial)));
	}
	
	
	@Test
	public void testCheckAnswer1()
	{
		LinkedList<Term> result = new LinkedList<Term>();
		LinkedList<Term> polynomial1 = new LinkedList<Term>();
		LinkedList<Term> polynomial2 = new LinkedList<Term>();
		
		//Adding terms to result
		
 		result.addFirst(new Term(3,0));
 		result.addFirst(new Term(3,1));
 		result.addFirst(new Term(7,2));
 		result.addFirst(new Term(2,3));
		
		//Adding terms to first polynomial
		polynomial1.addFirst(new Term(2,0));
		polynomial1.addFirst(new Term(4,1));
		polynomial1.addFirst(new Term(5,2));
		polynomial1.addFirst(new Term(6,3));
		
		//Adding terms to second polynomial
		polynomial2.addFirst(new Term(1,0));
		polynomial2.addFirst(new Term(-1,1));
		polynomial2.addFirst(new Term(2,2));
		polynomial2.addFirst(new Term(-4,3));
		
		testPolyAddition(result,polynomial1.iterator(),polynomial2.iterator());
	}
	
	
	@Test
	public void testCheckAnswer2()
	{
		LinkedList<Term> result = new LinkedList<Term>();
		LinkedList<Term> polynomial1 = new LinkedList<Term>();
		LinkedList<Term> polynomial2 = new LinkedList<Term>();
		
		//Adding terms to result
		
 		result.addFirst(new Term(3,0));
 		result.addFirst(new Term(3,1));
 		result.addFirst(new Term(2,2));
 		result.addFirst(new Term(6,3));
		
		//Adding terms to first polynomial
		polynomial1.addFirst(new Term(2,0));
		polynomial1.addFirst(new Term(4,1));
		//polynomial1.addFirst(new Term(5,2));
		polynomial1.addFirst(new Term(6,3));
		
		//Adding terms to second polynomial
		polynomial2.addFirst(new Term(1,0));
		polynomial2.addFirst(new Term(-1,1));
		polynomial2.addFirst(new Term(2,2));
		//polynomial2.addFirst(new Term(-4,3));
		
		testPolyAddition(result,polynomial1.iterator(),polynomial2.iterator());
	}
	
	
	@Test
	public void testCheckAnswer3()
	{
		LinkedList<Term> result = new LinkedList<Term>();
		LinkedList<Term> polynomial1 = new LinkedList<Term>();
		LinkedList<Term> polynomial2 = new LinkedList<Term>();
		
		//Adding terms to result
		
 		result.addFirst(new Term(2,0));
 		result.addFirst(new Term(4,1));
 		result.addFirst(new Term(5,2));
 		result.addFirst(new Term(6,3));
		
		//Adding terms to first polynomial
		polynomial1.addFirst(new Term(2,0));
		polynomial1.addFirst(new Term(4,1));
		polynomial1.addFirst(new Term(5,2));
		polynomial1.addFirst(new Term(6,3));
		
		testPolyAddition(result,polynomial1.iterator(),polynomial2.iterator());
	}
	
	@Test
	public void testCheckAnswer4()
	{
		LinkedList<Term> result = new LinkedList<Term>();
		LinkedList<Term> polynomial1 = new LinkedList<Term>();
		LinkedList<Term> polynomial2 = new LinkedList<Term>();
		
		//Adding terms to result
		
 		result.addFirst(new Term(1,0));
 		result.addFirst(new Term(-1,1));
 		result.addFirst(new Term(2,2));
 		result.addFirst(new Term(-4,3));
		
		//Adding terms to second polynomial
		polynomial2.addFirst(new Term(1,0));
		polynomial2.addFirst(new Term(-1,1));
		polynomial2.addFirst(new Term(2,2));
		polynomial2.addFirst(new Term(-4,3));
		
		testPolyAddition(result,polynomial1.iterator(),polynomial2.iterator());
	}
	
	@Test
	public void testCheckAnswer5()
	{
		LinkedList<Term> result = new LinkedList<Term>();
		LinkedList<Term> polynomial1 = new LinkedList<Term>();
		LinkedList<Term> polynomial2 = new LinkedList<Term>();
		
		//Adding terms to result
		
 		result.addFirst(new Term(3,0));
 		result.addFirst(new Term(-1,1));
 		result.addFirst(new Term(2,2));
 		result.addFirst(new Term(-4,3));
		
		//Adding terms to first polynomial
		polynomial1.addFirst(new Term(2,0));
		
		//Adding terms to second polynomial
		polynomial2.addFirst(new Term(1,0));
		polynomial2.addFirst(new Term(-1,1));
		polynomial2.addFirst(new Term(2,2));
		polynomial2.addFirst(new Term(-4,3));
		
		testPolyAddition(result,polynomial1.iterator(),polynomial2.iterator());
	}
	
	@Test
	public void testCheckAnswer6()
	{
		LinkedList<Term> result = new LinkedList<Term>();
		LinkedList<Term> polynomial1 = new LinkedList<Term>();
		LinkedList<Term> polynomial2 = new LinkedList<Term>();
		
		//Adding terms to result
		
 		result.addFirst(new Term(3,0));
 		result.addFirst(new Term(4,1));
 		result.addFirst(new Term(5,2));
 		result.addFirst(new Term(6,3));
		
		//Adding terms to first polynomial
		polynomial1.addFirst(new Term(2,0));
		polynomial1.addFirst(new Term(4,1));
		polynomial1.addFirst(new Term(5,2));
		polynomial1.addFirst(new Term(6,3));
		
		//Adding terms to second polynomial
		polynomial2.addFirst(new Term(1,0));
		
		testPolyAddition(result,polynomial1.iterator(),polynomial2.iterator());
	}
	
}
