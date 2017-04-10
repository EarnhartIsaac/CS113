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
			if(data != null)
			{
				return data.toString();
			}
			return "";
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
	
	public void createLeftNode()
	{
		this.root.left = new Node<E>(null);
	}
	
	public void createRightNode()
	{
		this.root.right = new Node<E>(null);
	}
	
	@Override
	public E getData() 
	{
		if(root != null)
		{
			return root.data;
		}
		return null;
	}
	
	public void add(E data)
	{
		if(this.root == null)
		{
			this.root = new Node<E>(data);
		}
		else
		{
			this.root.data = data;
		}
	}

	@Override
	public boolean isLeaf() 
	{
		return (root.left == null && root.right == null);
	}
	
	private void preOrderTraversal(Node<E> node,int depth,StringBuilder sb)
	{
		for (int i = 1; i < depth; i++) 
		{
			sb.append(" ");
		}
		if (node == null) 
		{
			sb.append("null\n");
		} 
		else 
		{
			sb.append(node.toString() + "\n");
			preOrderTraversal(node.left, depth + 1, sb);
			preOrderTraversal(node.right, depth + 1, sb);
		}
	}
	
	public String findMorsePath(E data)
	{
		StringBuilder sb = new StringBuilder();
		findPath(this.root,data,"",sb);
		return sb.toString();
	}
	
	private void findPath(Node<E> node,E data,String currentPath,StringBuilder sb)
	{
		if(node != null)
		{
			if(this.root.data.equals(data))
			{
				sb.append(currentPath);
			}
			else
			{
				findPath(node.left,data,currentPath + "*",sb);
				findPath(node.right,data,currentPath + "-",sb);
			}
		}
	}
	
	public static BinaryTree<String> readBinaryString(Scanner scan)
	{
		String data = scan.next();
		if(data.equals("null"))
		{
			return null;
		}
		else
		{
			BinaryTree<String> leftTree = readBinaryString(scan);
			BinaryTree<String> rightTree = readBinaryString(scan);
			return new BinaryTree<String>(data, leftTree, rightTree);
		}
	}
	
	public static BinaryTree<Character> readBinaryChar(Scanner scan)
	{
		String data = scan.next();
		if(data.equals("null"))
		{
			return null;
		}
		else
		{
			BinaryTree<Character> leftTree = readBinaryChar(scan);
			BinaryTree<Character> rightTree = readBinaryChar(scan);
			return new BinaryTree<Character>(data.charAt(0), leftTree, rightTree);
		}
	}
	
	
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		preOrderTraversal(root, 1, sb);
		return sb.toString();
	}
} 
