package edu.miracosta.cs113;

import edu.miracosta.cs113.LinkedList.Node;

public class Iterator<T>
{
	private LinkedList<T>.Node<T> currentNode;
	private LinkedList<T>.Node<T> head;
	
	public Iterator(LinkedList<T>.Node<T> head)
	{
		this.head = head;
		currentNode.setNextNode(head);
	}
	
	public LinkedList<T>.Node<T> next()
	{
		currentNode = currentNode.getNextNode();
		return currentNode;
	}
	
	public boolean hasNext()
	{
		return currentNode.getNextNode() != null;
	}
}
