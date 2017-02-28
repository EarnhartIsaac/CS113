package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Use
 * @author Isaac Earnhart
 * @since 02/28/2017
 * @param <E> the object type this data structure works with
 */
public class ArrayStack<E> implements Stack<E>
{
	private ArrayList<E> theData;
	
	/**
	 * Calls the default constructor for theData
	 */
	public ArrayStack()
	{
		this.theData = new ArrayList<E>();
	}
	
	/**
	 * checks to see if the stack is empty or not
	 * @return returns true if the stack is empty
	 */
	public boolean isEmpty()
	{
		return theData.isEmpty();
	}
	
	/**
	 * looks at the object at the top of the stack
	 * without modifying it
	 * @return the object at the top of the stack
	 */
	public E peek()
	{
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		return theData.get(theData.size() - 1);
	}
	
	/**
	 * pulls the object off the top of the stack
	 * and deletes it from the stack
	 * @return the value on the top of the stack
	 */
	public E pop()
	{
		if(isEmpty())
		{
			throw new NoSuchElementException();
		}
		return theData.remove(theData.size() - 1);
	}
	
	/**
	 * adds a object to the top of the stack
	 * @param the object to add
	 * @return the object that was added to the top of the stack
	 */
	public E push(E obj)
	{
		theData.add(obj);
		return obj;
	}
	
	public static void main(String[] args)
	{
		ArrayStack<String> theStack = new ArrayStack<String>();
		
		System.out.println("Testing isEmpty");
		System.out.println("Next line should be true if isEmpty working for empty list");
		System.out.println(theStack.isEmpty());
		
		try
		{
			theStack.pop();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("If you see this line then pop method works like it should with empty list");
		}
		
		try
		{
			theStack.peek();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("If you see this line then peek method works like it should with empty list");
		}
		
		
		theStack.push("I ");
		theStack.push("It is ");
		theStack.push("World. ");
		theStack.push("Hello ");
		
		System.out.println("Testing peek with data");
		System.out.println("Next line should say Hello");
		System.out.println(theStack.peek());
		
		System.out.println("Testing push,isEmpty,and pop all with data");
		System.out.println("Next line should say, Hello World. It is I");
		while(!theStack.isEmpty())
		{
			System.out.print(theStack.pop());
		}
	}
}
