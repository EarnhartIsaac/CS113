package edu.miracosta.cs113;

public class LinkedList<T>
{
	private Node<T> head;
	private int size;
	
	public Iterator iterator()
	{
		return new Iterator()
	}
	
	public void addFirst(T data)
	{
		head = new Node<T>(data,head);
		size++;
	}
	
	public void addAfter(Node<T> node,T data)
	{
		node.setNextNode(new Node<T>(data,node.nextNode));
		size++;
	}
	
	public boolean remove(Node<T> node)
	{
		Node<T> temp1 = this.head;
		Node<T> temp2 = this.head;
		while(temp1 != node && temp1 != null)
		{
			temp2 = temp1;
			temp1 = temp1.nextNode;
		}
		if(temp1 != null)
		{
			temp2.nextNode = temp1.nextNode;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void removeAfter(Node<T> node)
	{
		node.nextNode = node.nextNode.nextNode;
		size--;
	}
	
	public void removeFirst()
	{
		this.head = this.head.nextNode;
	}
	
	public Node<T> getNode(int index)
	{
		Node<T> temp = this.head;
		for(int counter = 0;counter<index;counter++)
		{
			temp = temp.nextNode;
		}
		return temp;
	}
	
	public class Node<T> 
	{
		private T data;
		private Node<T> nextNode;
		
		public void setData(T data)
		{
			this.data = data;
		}
		
		public void setNextNode(Node<T> nextNode)
		{
			this.nextNode = nextNode;
		}
		
		public Node(T data,Node<T> nextNode)
		{
			this.setData(data);
			this.setNextNode(nextNode);
		}
		
		public T getData()
		{
			return this.data;
		}
		
		public Node<T> getNextNode()
		{
			return this.nextNode;
		}
	}
}
