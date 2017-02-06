package edu.miracosta.cs113;

public class Main 
{
	public static void main(String[] args)
	{
		int y1;
		int y2;
		for(int counter = 0;counter<100;counter +=10)
		{
			y1 = 100* counter + 10;
			y2 = 5 * counter * counter + 2;
			System.out.printf("%-15s%10d","y1 - y2 = ",y1-y2);
			System.out.printf("%-10s%10d","\ty1 = ",y1);
			System.out.printf("%-10s%10d%n","\ty2 = ",y2);
		}
	}
}
