package dataStructures;

import java.io.Serializable;
import java.util.Scanner;

public class BinaryTree<E> implements BinaryTreeInterface<E>
{
	protected Node<E> root;
	
	public BinaryTree()
	{
		root = null;
	}
	
	protected BinaryTree(Node<E> root)
	{
		this.root = root;
	}
	
	public BinaryTree(E data,BinaryTree<E> leftTree, BinaryTree<E> rightTree)
	{
		root = new Node<E>(data);
		if(leftTree != null)
		{
			root.left = leftTree.root;
		}
		else
		{
			root.left = null;
		}
		if(rightTree != null)
		{
			root.right = rightTree.root;
		}
		else
		{
			root.right = null;
		}
	}
	
	@SuppressWarnings("serial")
	protected static class Node<E> implements Serializable
	{
		protected E data;
		protected Node<E> left;
		protected Node<E> right;
		
		public Node(E data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		public String toString()
		{
			return data.toString();
		}
	}

	@Override
	public BinaryTree<E> getLeftSubtree() 
	{
		if(root != null && root.left != null)
		{
			return new BinaryTree<E>(root.left);
		}
		else
		{
			return null;
		}
	}

	@Override
	public BinaryTree<E> getRightSubtree() 
	{
		if(root != null && root.right != null)
		{
			return new BinaryTree<E>(root.right);
		}
		else
		{
			return null;
		}
	}

	@Override
	public E getData() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLeaf() 
	{
		return (root.left == null && root.right == null);
	}
	
	private void preOrderTraversal(Node<E> node,int depth,StringBuilder sb)
	{
		
	}
	
	public static BinaryTree<String> readBinary(Scanner scan)
	{
		String data = scan.next();
		if(data.equals("null"))
		{
			return null;
		}
		else
		{
			BinaryTree<String> leftTree = readBinary(scan);
			BinaryTree<String> rightTree = readBinary(scan);
			return new BinaryTree<String>(data, leftTree, rightTree);
		}
	}
} 
