package test_trl;
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

/**
 * PatronTest
 * 
 * Patron Class Test
 * 
 * @author Kevin Um
 * @author Justin Siu-Ting Hui
 * @author Sheng Lor
 * 
 * @date December 16, 2017
 *
 */
public class PatronTest
{
	// Class Under Test
	Patron CUT;

	Patron CUT2;
	private final String copyID = "TEST_COPY_ID";
	private final String copyTitle = "TEST_COPY_TITLE";
	private final String patronID = "TEST_PATRON_ID";
	private final String patronName = "PATRON NAME";	
	private final String patronID2 = "TEST_PATRON_ID2";
	private final String patronName2 = "PATRON NAME2";	
	private Copy c1, c2;
	
	@Before
	public void setUp() {
		CUT = new Patron(patronID, patronName);
		CUT2 = new Patron(patronID2, patronName2);
		c1 = new Copy("T_C1", "T_C1");
		c2 = new Copy("T_C2", "T_C2");
	}
	
	@Test
	public void constructor_test(){
		// CUT is instantiated in setUp()
		assert(CUT != null);
		assertEquals(CUT.getPatronID(), patronID);
		assertEquals(CUT.getName(), patronName);
	}
	
	@Test
	public void validatingPatronCheckedOutZeroCopies() throws Exception {
		int result=CUT.numCheckedOutCopies();
		assertEquals(0,result);
	}
	
	@Test
	public void validatingPatronCanCheckOut() throws Exception{
		boolean result=CUT.checkCopyOut(c1);
		assertEquals(true,result);
		CUT.checkCopyIn(c1);
	}
	
	@Test
	public void validatingPatronCannotCheckOutCheckedOutCopies() throws Exception{
		CUT.checkCopyOut(c1);
		boolean result=CUT.checkCopyOut(c1);
		assertEquals(false,result);
	}
	
	@Test
	public void validatingPatronCanCheckIn() throws Exception{
		CUT.checkCopyOut(c1);
		boolean result=CUT.checkCopyIn(c1);
		assertEquals(true,result);
	}
	
	@Test
	public void validatingPatronCannotCheckInWhenPatronHasNoCheckedOutCopy() throws Exception{
		assertEquals(false, CUT.checkCopyIn(c1));
	}
	
	@Test
	public void printPatronInfoTest() throws Exception{
	String expectedResult= "Patron ID: " + CUT.getPatronID() + "\nName: " + CUT.getName() + "\nBooks Borrowing: " + CUT.getCopiesOut()+ "\nHolds: []\n";
	String actultResult=CUT.toString();
	assertEquals(expectedResult,actultResult);
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
		ArrayList<Copy> copies = new ArrayList<Copy>();
		copies.add(c1);
		copies.add(c2);
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
