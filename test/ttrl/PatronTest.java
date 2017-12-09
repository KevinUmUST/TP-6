package ttrl;
/**
 *  PatronTest (TP_1)
 *  SEIS 635 - Software Analysis and Design
 * 
 * 	Description: This class implements TP_1 - Exploration and Beginning 
 * 				Implementation for the TRL project. 	
 * 
 * 	@author	Kevin Um, Justin Hui, Sheng Lor
 * 
 * */
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import trl.Copy;
import trl.Hold;
import trl.Patron;
import trl.TRLLibrary;

public class PatronTest
{
	// Class Under Test
	Patron CUT;
	
	private final String copyID = "TEST_COPY_ID";
	private final String copyTitle = "TEST_COPY_TITLE";
	private final String patronID = "TEST_PATRON_ID";
	private final String patronName = "PATRON NAME";	
	
	@Test
	public void tp1_test()
	{
		TRLLibrary db = new TRLLibrary();
		Patron p;
		String s;
		
		System.out.println("Patron Test - TP_1: Exploration and Beginning Implementation");
		System.out.println("Start of Test");
		System.out.println("\n");
		
		System.out.println("=============================================================");
		System.out.println("=======================   PATRON INFO   =====================");
		System.out.println("=============================================================");
		System.out.println(s = (p = db.getPatron("P1")).toString());
		assertEquals(s,"Patron ID: P1\nName: Eric\nBooks Borrowing: []\nHolds: []\n");
		
		System.out.println("=============================================================");
		System.out.println("==============  CHECKING OUT FIRST COPY ...  ================");
		System.out.println("=============================================================");
		p.checkCopyOut(db.getCopy("C1"));
		System.out.println(s = (p = db.getPatron("P1")).toString());
		assertEquals(s,"Patron ID: P1\nName: Eric\nBooks Borrowing: [Copy ID: " + 
					   "C1\nTitle: Fun with Objects\nChecked Out To: Eric\n]\nHolds: []\n");
		
		System.out.println("=============================================================");
		System.out.println("==============  CHECKING OUT SECOND COPY ...  ===============");
		System.out.println("=============================================================");
		p.checkCopyOut(db.getCopy("C2"));
		System.out.println(s = (p = db.getPatron("P1")).toString());
		assertEquals(s,"Patron ID: P1\nName: Eric\nBooks Borrowing: [Copy ID: " +
					   "C1\nTitle: Fun with Objects\nChecked Out To: Eric\n, Copy" +
					   " ID: C2\nTitle: More Fun with Objects\nChecked Out To: Eric\n]\nHolds: []\n");
		
		System.out.println("=============================================================");
		System.out.println("==============  CHECKING IN SECOND COPY ...  ===============");
		System.out.println("=============================================================");
		p.checkCopyIn(db.getCopy("C2"));
		System.out.println(s = (p = db.getPatron("P1")).toString());
		assertEquals(s,"Patron ID: P1\nName: Eric\nBooks Borrowing: [Copy ID: " +
					   "C1\nTitle: Fun with Objects\nChecked Out To: Eric\n]\nHolds: []\n");
		
		System.out.println("=============================================================");
		System.out.println("==============  CHECKING IN FIRST COPY ...  ===============");
		System.out.println("=============================================================");
		p.checkCopyIn(db.getCopy("C1"));
		System.out.println(s = (p = db.getPatron("P1")).toString());
		assertEquals(s,"Patron ID: P1\nName: Eric\nBooks Borrowing: []\nHolds: []\n");
		
		System.out.println("Patron Test - TP_1: Exploration and Beginning Implementation");
		System.out.println("End of Test");
	}
	
	@Before
	public void setUp() {
		CUT = new Patron(patronID, patronName);
	}
	
	@Test
	public void constructor_test(){
		// CUT is instantiated in setUp()
		assert(CUT != null);
		assertEquals(CUT.getPatronID(), patronID);
		assertEquals(CUT.getName(), patronName);
	}
	
	@Test
	public void getset_test(){
		// Patron Name
		String newName = patronName + "*";
		CUT.setName(newName);
		assertEquals(CUT.getName(), newName);
		CUT.setName(patronName);

		// Patron ID
		String newPatronID = patronID + "*";
		CUT.setPatronID(newPatronID);
		assertEquals(CUT.getPatronID(), newPatronID);
		CUT.setPatronID(patronID);
	
		// Copies Out List Type
		assert(CUT.getCopiesOut() instanceof ArrayList<?>);

		// Copies Out List
		Copy c1, c2;
		ArrayList<Copy> copies = new ArrayList<Copy>();
		copies.add(c1 = new Copy("T_C1", "T_C1"));
		copies.add(c2 = new Copy("T_C2", "T_C2"));
		CUT.setCopiesOut(copies);
		assert(CUT.getCopiesOut().get(0).equals(c1));
		assert(CUT.getCopiesOut().get(1).equals(c2));
		CUT.setCopiesOut(new ArrayList<Copy>());
	}
	
	@Test
	public void hold_test(){
		Copy c = new Copy("C0", "C0_Name");
		Hold h = new Hold(c);
		
		assert(CUT.numHolds() == 0);
		
		CUT.addHold(h);
		assert(CUT.numHolds() == 1);
	
		CUT.removeHold(h);
		assert(CUT.numHolds() == 0);
	}
	
	@Test
	public void equals_test(){
		// Same Patron ID but Different Title
		Patron otherPatron = new Patron(patronID, "Different Title");
		assert(CUT.equals(otherPatron));
	
		// Same Patron ID and Same Title
		otherPatron = new Patron(patronID, patronName);
		assert(CUT.equals(otherPatron));
	
		// Different Patron ID and Same Title
		otherPatron = new Patron("Different ID", patronName);
		assert(!CUT.equals(otherPatron));
		
		// Different Patron ID and Different Title
		otherPatron = new Patron("Different ID", "Different Name");
		assert(!CUT.equals(otherPatron));
		
		// Not an instance of Patron
		assert(!CUT.equals(new Copy("", "")));
	}
}
