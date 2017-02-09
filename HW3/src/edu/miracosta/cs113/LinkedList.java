package edu.miracosta.cs113;

public class LinkedList<T>
{
	private Node head;
	private int size;
	
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
