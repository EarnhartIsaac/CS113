package edu.miracosta.cs113;

import java.util.Scanner;

public class RtTriangle extends Shape 
{

	//DATA
	/** width of rectangle */
	private double width = 0;
	/** The height of the rectangle */
	private double height = 0;
	
	//Constructors
	public RtTriangle()
	{
		super("RtTriangle");
	}
	
	/**Constructs a right triangle of specific size
	 * @param width the width
	 * @param height the height
	 */
	public RtTriangle(double width,double height)
	{
		super("RtTriangle");
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
		return height*width / 2;
	}

	@Override
	public double computePerimeter() 
	{
		return height + width + Math.sqrt((height * height) + (width * width));
	}

	@Override
	public void readShapeData() 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the width of triangle");
		width = in.nextDouble();
		System.out.println("Eneter the height of triangle");
		height = in.nextDouble();
		in.close();
	}
	
	@Override
	public String toString()
	{
		return super.toString() + ": width is " + width + ", height is " + height;
	}

}
