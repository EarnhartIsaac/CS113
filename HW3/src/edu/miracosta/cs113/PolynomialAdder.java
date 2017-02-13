package edu.miracosta.cs113;

public class PolynomialAdder 
{	
	public static LinkedList<Term> addPolynomials
			(Iterator<Term> firstPolynomial,
			Iterator<Term> secondPolynomial)
	{
		//No idea how to shorten or better organize this code, kept hitting brick walls
		
		LinkedList<Term> result = new LinkedList<Term>();
		//Reference to previous node in order to call addAfter in LinkedList
		Node<Term> previousNode = null;
		
		boolean continueFirst = firstPolynomial.hasNext();
		boolean continueSecond = secondPolynomial.hasNext();
		
		Term firstTemp;
		Term secondTemp;
		
		if(continueFirst && continueSecond)
		{
			firstTemp = firstPolynomial.next().getData();
			secondTemp = secondPolynomial.next().getData();
			switch(firstTemp.compareTo(secondTemp))
			{
				case 1:
					previousNode = result.addFirst(firstTemp);
					continueFirst = firstPolynomial.hasNext();
					if(continueFirst)
					{
						firstTemp = firstPolynomial.next().getData();
					}

					break;
				case -1:
					previousNode = result.addFirst(secondTemp);
					continueSecond = secondPolynomial.hasNext();
					if(continueSecond)
					{
						secondTemp = secondPolynomial.next().getData();
					}

					break;
				case 0:
					previousNode = result.addFirst(new Term(firstTemp.getCoefficient() + secondTemp.getCoefficient(),
											 firstTemp.getExponent()));
					continueFirst = firstPolynomial.hasNext();
					continueSecond = secondPolynomial.hasNext();
					
					if(continueFirst)
					{
						firstTemp = firstPolynomial.next().getData();
					}
					if(continueSecond)
					{
						secondTemp = secondPolynomial.next().getData();
					}
					
					break;
			}
			
			while(continueFirst || continueSecond)
			{
				if(continueFirst && continueSecond)
				{
					switch(firstTemp.compareTo(secondTemp))
					{
						case 1:
							previousNode = result.addAfter(previousNode,firstTemp);
							continueFirst = firstPolynomial.hasNext();
							if(continueFirst)
							{
								firstTemp = firstPolynomial.next().getData();
							}

							break;
						case -1:
							previousNode = result.addAfter(previousNode,secondTemp);
							continueSecond = secondPolynomial.hasNext();
							if(continueSecond)
							{
								secondTemp = secondPolynomial.next().getData();
							}
							
							break;
						case 0:
							previousNode = result.addAfter(previousNode,
														   new Term(firstTemp.getCoefficient() + 
																   secondTemp.getCoefficient(),
														   firstTemp.getExponent()));
							continueFirst = firstPolynomial.hasNext();
							continueSecond = secondPolynomial.hasNext();
							if(continueFirst)
							{
								firstTemp = firstPolynomial.next().getData();
							}
							if(continueSecond)
							{
								secondTemp = secondPolynomial.next().getData();
							}
							
							break;
					}
					
				}
				else if(continueFirst)
				{
					while(firstPolynomial.hasNext())
					{
						firstTemp = firstPolynomial.next().getData();
						previousNode = result.addAfter(previousNode,firstTemp);
					}
				}
				else if(continueSecond)
				{
					while(secondPolynomial.hasNext())
					{
						secondTemp = secondPolynomial.next().getData();
						previousNode = result.addAfter(previousNode,secondTemp);	
					}
				}
			}
			
		}
		else if(continueFirst)
		{
			firstTemp = firstPolynomial.next().getData();
			previousNode = result.addFirst(firstTemp);
			while(firstPolynomial.hasNext())
			{
				firstTemp = firstPolynomial.next().getData();
				previousNode = result.addAfter(previousNode,firstTemp);	
			}
		
		}
		else if(continueSecond)
		{
			secondTemp = secondPolynomial.next().getData();
			previousNode = result.addFirst(secondTemp);
			while(secondPolynomial.hasNext())
			{
				secondTemp = secondPolynomial.next().getData();
				previousNode = result.addAfter(previousNode,secondTemp);	
			}
		}

		return result;
	}
}
