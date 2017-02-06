package edu.miracosta.cs113;

import java.util.Scanner;

public class Circle extends Shape
{

	//DATA
	/** radius of circle */
	private double radius = 0;
	
	//Constructors
	public Circle()
	{
		super("Circle");
	}
	
	/**Constructs a Circle of a specific size
	 * @param radius the radius of the circle
	 */
	public Circle(double radius)
	{
		super("Circle");
		this.radius = radius;
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	@Override
	public double computeArea() 
	{
		return radius * radius * 3.14;
	}

	@Override
	public double computePerimeter() 
	{
		return radius * 6.28;
	}

	@Override
	public void readShapeData() 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the radius of the circle");
		radius = in.nextDouble();
		in.close();
	}
	
	@Override
	public String toString()
	{
		return super.toString() + ": radius is " + radius;
	}
}
