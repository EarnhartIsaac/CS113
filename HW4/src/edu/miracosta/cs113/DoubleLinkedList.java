package edu.miracosta.cs113;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<E> implements List<E>
{
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	@Override
	public boolean add(E arg0)
	{
		
		return true;
	}

	@Override
	public void add(int arg0, E arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int arg0) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E remove(int arg0) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int arg0, E arg1) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<E> subList(int arg0, int arg1) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	private static class Node<E>
	{
		private E data;
		private Node<E> nextNode;
		private Node<E> previousNode;
		
		private Node(E data)
		{
			this.data = data;
		}
		
		public Node(E data,Node<E> previousNode,Node<E> nextNode)
		{
			this.data = data;
			this.previousNode = previousNode;
			this.nextNode = nextNode;
		}
	}
	
	public class DoubleListIterator implements ListIterator<E>
	{
		private Node<E> nextItem;
		private Node<E> lastItemReturned;
		private int index;

		public DoubleListIterator(int i) 
		{
			// error check index
			if (i < 0 || i > size) 
			{
				throw new IndexOutOfBoundsException("Invalid index " + i);
			}
			lastItemReturned = null; // No item returned yet
			// Special case of last item (why not let loop do this?)
			if (i == size) 
			{
				index = size;
				nextItem = null;
			} 
			else 
			{ // Start at the beginning
				nextItem = head;
				for (index = 0; index < i; index++) 
				{
					nextItem = nextItem.nextNode;
				}
			}
		}
	
		
		@Override
		public void add(E arg0) 
		{
			if(head == null)
			{
				head = new Node<E>(arg0);
			}
			else if(nextItem == head)
			{
				head = new Node<E>(arg0,null,nextItem);
			}
			else if(nextItem == null)
			{
				
			}
		} 

		@Override
		public boolean hasNext() 
		{
			return this.nextItem != null;
		}

		@Override
		public boolean hasPrevious() 
		{
			return this.nextItem.previousNode != null;
		}

		@Override
		public E next() 
		{
			if (!hasNext()) {
			throw new NoSuchElementException();
			}
			lastItemReturned = nextItem;
			nextItem = nextItem.nextNode;
			index++;
			return lastItemReturned.data;
		}

		@Override
		public int nextIndex() 
		{
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public E previous() 
		{
			if (!hasPrevious()) 
			{
				throw new NoSuchElementException();
			}
			if (nextItem == null)
			{
				nextItem = tail;
			}
			else 
			{
				nextItem = nextItem.previousNode;
			}
			lastItemReturned = nextItem;
			index--;
			return lastItemReturned.data;
		}

		@Override
		public int previousIndex() 
		{
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void remove() 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void set(E e) 
		{
			// TODO Auto-generated method stub
			
		}
		
	}

}
