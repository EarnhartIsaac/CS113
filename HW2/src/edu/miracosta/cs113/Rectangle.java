package edu.miracosta.cs113;

import java.util.Scanner;

/**
 * Represent a rectangle.
 * Extends shape
 * @author w7262233
 *
 */
public class Rectangle extends Shape {

	//DATA
	/** width of rectangle */
	private double width = 0;
	/** The height of the rectangle */
	private double height = 0;
	
	//Constructors
	public Rectangle()
	{
		super("Rectangle");
	}
	
	/**Constructs a rectangle of specific size
	 * @param width the width
	 * @param height the height
	 */
	public Rectangle(double width,double height)
	{
		super("Rectangle");
		this.width = width;
		this.height = height;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public double getHeight()
	{
		return height;
	}
	
	@Override
	public double computeArea() 
	{
		return height*width;
	}

	@Override
	public double computePerimeter() 
	{
		return 2 * (height + width);
	}

	@Override
	public void readShapeData() 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the width of rectangle");
		width = in.nextDouble();
		System.out.println("Eneter the height of rectangle");
		height = in.nextDouble();
	}
	
	@Override
	public String toString()
	{
		return super.toString() + ": width is " + width + ", height is " + height;
	}

}
