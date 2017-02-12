package edu.miracosta.cs113;

public class Iterator<T>
{
	private Node<T> currentNode;
	private Node<T> head;
	
	public Iterator(Node<T> head)
	{
		currentNode = new Node<T>(null,head);
		this.head = head;
	}
	
	public LinkedList<T> linkedList()
	{
		return new LinkedList<T>(this.head);
	}
	
	public Node<T> next()
	{
		currentNode = currentNode.getNextNode();
		return currentNode;
	}
	
	public boolean hasNext()
	{
		return currentNode.getNextNode() != null;
	}
}
