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
		
		//
		System.out.println(continueFirst);
		System.out.println(continueSecond);
		//
		
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
					//
					System.out.println(previousNode + "1");
					System.out.println(continueFirst);
					System.out.println(continueSecond);
					//

					break;
				case -1:
					previousNode = result.addFirst(secondTemp);
					continueSecond = secondPolynomial.hasNext();
					
					//
					System.out.println(previousNode + "-1");
					//

					break;
				case 0:
					previousNode = result.addFirst(new Term(firstTemp.getCoefficient() + secondTemp.getCoefficient(),
											 firstTemp.getExponent()));
					continueFirst = firstPolynomial.hasNext();
					continueSecond = secondPolynomial.hasNext();
					
					//
					System.out.println(previousNode + "0");
					//
					
					break;
			}
			
		}
		else if(continueFirst)
		{
			firstTemp = firstPolynomial.next().getData();
			previousNode = result.addFirst(firstTemp);
			continueFirst = firstPolynomial.hasNext();
			
			System.out.println(previousNode);
		
		}
		else if(continueSecond)
		{
			secondTemp = secondPolynomial.next().getData();
			previousNode = result.addFirst(secondTemp);
			continueSecond = secondPolynomial.hasNext();
			
			System.out.println(previousNode);
		}
		
		//
		//System.out.println(continueFirst);
		//System.out.println(continueSecond);
		//
		
		while(continueFirst || continueSecond)
		{
			if(continueFirst && continueSecond)
			{
				firstTemp = firstPolynomial.next().getData();
				secondTemp = secondPolynomial.next().getData();
				switch(firstTemp.compareTo(secondTemp))
				{
					case 1:
						previousNode = result.addAfter(previousNode,firstTemp);
						continueFirst = firstPolynomial.hasNext();
						
						System.out.println(previousNode + "case1");

						break;
					case -1:
						previousNode = result.addAfter(previousNode,secondTemp);
						continueSecond = secondPolynomial.hasNext();
						
						System.out.println(previousNode + "case-1");
						
						break;
					case 0:
						previousNode = result.addAfter(previousNode,
													   new Term(firstTemp.getCoefficient() + 
															   secondTemp.getCoefficient(),
													   firstTemp.getExponent()));
						continueFirst = firstPolynomial.hasNext();
						continueSecond = secondPolynomial.hasNext();
						
						System.out.println(previousNode + "case0");
						
						break;
				}
				
			}
			else if(continueFirst)
			{
				firstTemp = firstPolynomial.next().getData();
				previousNode = result.addAfter(previousNode,firstTemp);
				
				System.out.println(previousNode);
				
				continueFirst = firstPolynomial.hasNext();
			}
			else if(continueSecond)
			{
				secondTemp = secondPolynomial.next().getData();
				previousNode = result.addAfter(previousNode,secondTemp);
				
				System.out.println(previousNode);

				continueSecond = secondPolynomial.hasNext();
			}
		}
		return result;
	}
}
