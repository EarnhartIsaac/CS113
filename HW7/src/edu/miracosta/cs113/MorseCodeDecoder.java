package edu.miracosta.cs113;

import dataStructures.BinaryTree;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MorseCodeDecoder 
{
	public static void main(String[] args)
	{
		BinaryTree<Character> morseDecoder = new BinaryTree<Character>();
		morseDecoder.add(null);
		treeFromFile("morse.txt",morseDecoder);
		System.out.println(morseDecoder.findMorsePath('e'));
		System.out.println(morseDecoder.decode("*--*"));
		
	}
	/**
	 * tree must have a root node that is not null
	 * @param code
	 * @param character
	 * @param tree
	 */
	public static void addToTree(String code,char character,BinaryTree<Character> tree)
	{
		if(code.length() != 0)
		{
			switch(code.charAt(0))
			{
				case '*':
					tree.createLeftNode();
					addToTree(code.substring(1),character,tree.getLeftSubtree());
					break;
				case '-':
					tree.createRightNode();
					addToTree(code.substring(1),character,tree.getRightSubtree());
					break;
				default:
					System.out.println(code + " is an invalid code for character " + character);
					break;
			}
		}
		else
		{
			tree.add(character);
		}
	}
	/**
	 * 
	 * @param textFile
	 * @param tree
	 */
	public static void treeFromFile(String textFile,BinaryTree<Character> tree)
	{
		try
		{
			Scanner fileInput = new Scanner(new FileInputStream(textFile));
			while(fileInput.hasNext())
			{
				addToTree(fileInput.next(),fileInput.next().charAt(0),tree);
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
