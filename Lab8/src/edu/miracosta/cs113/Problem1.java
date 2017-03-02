package edu.miracosta.cs113;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1 
{
	public static void main(String[] args)
	{
		ArrayStack<Integer> stackList1 = new ArrayStack<Integer>();
		ArrayStack<Integer> stackList2 = new ArrayStack<Integer>();
		
		Queue<Integer> queueList = new LinkedList<Integer>();
		
		stackList1.push(-1);
		stackList1.push(15);
		stackList1.push(23);
		stackList1.push(44);
		stackList1.push(4);
		stackList1.push(99);
		
		System.out.println("stackList1 top " + stackList1.peek());
	
		while(!stackList1.isEmpty())
		{
			System.out.println("True if element " + 
								stackList1.peek() +
								" was added");
			System.out.println(queueList.offer(stackList1.peek()));
			
			stackList2.push(stackList1.pop());
		}
		
		System.out.println("stackList2 top " + stackList2.peek());
		System.out.println("queueList top " + queueList.peek());
		
		while(!stackList2.isEmpty()  &&  !queueList.isEmpty())
		{
			System.out.println("stackList2: " + 
							stackList2.pop() +
							"\tqueueList: " + 
							queueList.poll());
		}
	}
}
