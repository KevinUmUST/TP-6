import static org.junit.Assert.*;

import org.junit.Test;

/*  PatronTest (TP_1)
 *  SEIS 635 - Software Analysis and Design
 * 
 * 	Description: This class implements TP_1 - Exploration and Beginning 
 * 				Implementation for the TRL project. 	
 * 
 * 	Authors: Kevin Um, Justin Hui, Sheng Lor
 * 
 * */

public class PatronTest
{

	@Test
	public void test()
	{
		FakeDB db = new FakeDB();
		Patron p;
		String s;
		
		StdOut.println("Patron Test - TP_1: Exploration and Beginning Implementation");
		StdOut.println("Start of Test");
		StdOut.println("\n");
		
		StdOut.println("=============================================================");
		StdOut.println("=======================   PATRON INFO   =====================");
		StdOut.println("=============================================================");
		StdOut.println(s = (p = db.getPatron("P1")).toString());
		assertEquals(s,"Patron ID: P1\nName: Eric\nBooks Borrowing: []");
		
		StdOut.println("=============================================================");
		StdOut.println("==============  CHECKING OUT FIRST COPY ...  ================");
		StdOut.println("=============================================================");
		p.checkCopyOut(db.getCopy("C1"));
		StdOut.println(s = (p = db.getPatron("P1")).toString());
		assertEquals(s,"Patron ID: P1\nName: Eric\nBooks Borrowing: [Copy ID: " + 
					   "C1\nTitle: Fun with Objects\nChecked Out To: Eric]");
		
		StdOut.println("=============================================================");
		StdOut.println("==============  CHECKING OUT SECOND COPY ...  ===============");
		StdOut.println("=============================================================");
		p.checkCopyOut(db.getCopy("C2"));
		StdOut.println(s = (p = db.getPatron("P1")).toString());
		assertEquals(s,"Patron ID: P1\nName: Eric\nBooks Borrowing: [Copy ID: " +
					   "C1\nTitle: Fun with Objects\nChecked Out To: Eric, Copy" +
					   " ID: C2\nTitle: More Fun with Objects\nChecked Out To: Eric]");
		
		StdOut.println("Patron Test - TP_1: Exploration and Beginning Implementation");
		StdOut.println("End of Test");
	}

}
