package edu.miracosta.cs113;

public class Term implements Comparable<Term>
{
	private int coefficient;
	private int exponent;
	
	public void setCoefficient(int coefficient)
	{
		this.coefficient = coefficient;
	}
	
	public void setExponent(int exponent)
	{
		this.exponent = exponent;
	}
	
	public Term(int coefficient,int exponent)
	{
		this.setCoefficient(coefficient);
		this.setExponent(exponent);
	}
	
	public int getCoefficient()
	{
		return this.coefficient;
	}
	
	public int getExponent()
	{
		return this.exponent;
	}
	
	
	//TODO Deconstruct this method into pure mathematics
	/**
	 * Do not call this method on objects that are not instances of Term
	 * @param object the Term that this Term is being compared to
	 * @return -1 if object has a larger exponent than this term, 
	 * 			1 if this term's exponent is larger than object's,
	 * 			0 if then have equal exponents
	 */
	public int compareTo(Term object)
	{
		if(object != null)
		{
			Term temp = (Term)object;
			if(temp.getExponent() > this.getExponent())
			{
				return -1;
			}
			else if(temp.getExponent() < this.getExponent())
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		else return -2;

	}
	
	public String toString()
	{
		return this.getCoefficient() + "x^" + this.getExponent();
	}
	
	public boolean equals(Object object)
	{
		if(object == null)
		{
			return false;
		}
		Term test = (Term)object;
		return this.getCoefficient() == test.getCoefficient() &&
			   this.getExponent() == test.getExponent();
	}
}
