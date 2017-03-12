package driver;

import edu.miracosta.cs113.BasicPrinter;
import edu.miracosta.cs113.PrintJob;
import edu.miracosta.cs113.Printer;

public class PrintTester 
{
	public static void main(String[] args)
	{
		BasicPrinter[] printers = new BasicPrinter[3];
		
		printers[0] = new BasicPrinter(1,11,"Small Printer",1);
		printers[1] = new BasicPrinter(11,21,"Medium Printer",2);
		printers[2]  = new BasicPrinter(21,51,"Large Printer",3);
		
		PrintJob temp;
		
		for(int counter = 0;counter<100;counter++)
		{
			temp = new PrintJob("PrintJob " + counter,(int)(Math.random() * 50) + 1);
			
			//Adds only to the printer in its size boundaries
			printers[0].addPrintJob(temp);
			printers[1].addPrintJob(temp);
			printers[2].addPrintJob(temp);
			
			Printer.syncronizedTick(printers,3);
		}
		while(printers[0].isPrinting() || 
				printers[1].isPrinting() ||
				printers[2].isPrinting())
		{
			Printer.syncronizedTick(printers,3);
		}
	}
}
