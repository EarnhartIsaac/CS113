package edu.miracosta.cs113;

public class LinkedList<T>
{
	private Node<T> head;
	private int size;
	
	public LinkedList()
	{
		this.size = 0;
		this.head = null;
	}
	
	public LinkedList(Node<T> head)
	{
		this.head = head;
		this.size = 0;
	}
	
	public Iterator<T> iterator()
	{
		return new Iterator<T>(head);
	}
	
	public Node<T> addFirst(T data)
	{
		Node<T> temp = new Node<T>(data,head);
		head = temp;
		size++;
		return temp;
	}
	
	public Node<T> addAfter(Node<T> node,T data)
	{
		Node<T> temp = new Node<T>(data,node.getNextNode());
		node.setNextNode(temp);
		size++;
		return temp;
	}
	
	public boolean remove(Node<T> node)
	{
		Node<T> temp1 = this.head;
		Node<T> temp2 = this.head;
		while(temp1 != node && temp1 != null)
		{
			temp2 = temp1;
			temp1 = temp1.getNextNode();
			size--;
		}
		if(temp1 != null)
		{
			temp2.setNextNode( temp1.getNextNode() );
			size--;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void removeAfter(Node<T> node)
	{
		node.setNextNode( node.getNextNode().getNextNode() );
		size--;
	}
	
	public void removeFirst()
	{
		this.head = this.head.getNextNode();
		size--;
	}
	
	public Node<T> getNode(int index)
	{
		Node<T> temp = this.head;
		for(int counter = 0;counter<index;counter++)
		{
			temp = temp.getNextNode();
		}
		return temp;
	}
	
	public boolean equals(LinkedList<T> test)
	{
		Iterator<T> testNodes1 = this.iterator();
		Iterator<T> testNodes2 = test.iterator();
		
		while(testNodes1.hasNext() && testNodes2.hasNext())
		{
			//returns false if two nodes are not equal
			
			/***********************************
			// NOTE FOR NERY
			// What's your opinion on using a return statement 
			// half as a break like I did here
			// I thought this was pretty clever but I want your opinion
			************************************/
			
			if(!testNodes1.next().getData().equals(testNodes2.next().getData()))
			{
				return false;
			}
		}
		
		//returns false if there aren't the same number of nodes
		return (testNodes1.hasNext() == testNodes2.hasNext());	
	}
}
