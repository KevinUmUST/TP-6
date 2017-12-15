package test_trl;
import static org.junit.Assert.*;

import org.junit.Test;

import trl.TRLReturnType;
import trl.TRLSession;

/**
 * TRLSessionTest 
 * 
 * TRLSession Class Test
 * 
 * @author Kevin Um
 * @author Justin Siu-Ting Hui
 * @author Sheng Lor
 * 
 * @date December 16, 2017
 *
 */
public class TRLSessionTest {

	TRLSession CUT;		// Class Under Test
	String PatronID = "P5";
	String CopyID	= "C5";
	String BadPatronID = "XP1";
	String BadCopyID   = "XC1";
	
	public TRLSessionTest() {
		try {
			CUT = new TRLSession(PatronID);
		}
		catch (Exception e) {
			fail();
		}
		try {
			CUT = new TRLSession(BadPatronID);
			fail();
		}
		catch (Exception e){
			assert(true);
		}
	}
	
	@Test
	public void testValidatePatron() {
	    assertTrue(CUT.validatePatron(PatronID));
	    assertTrue(!CUT.validatePatron(BadPatronID));
	}

	@Test
	public void testValidateCopy() {
	    assertTrue(CUT.validateCopy(CopyID));
	    assertTrue(!CUT.validateCopy(BadCopyID));
	}

	@Test
	public void testCheckOutCopy() {
	    assertEquals(CUT.checkOutCopy(PatronID, CopyID), TRLReturnType.SUCCESS);
	    CUT.checkInCopy(PatronID, CopyID);
	    assertEquals(CUT.checkOutCopy(PatronID, BadCopyID), TRLReturnType.COPY_NOT_FOUND);
	    assertEquals(CUT.checkOutCopy(BadPatronID, CopyID), TRLReturnType.PATRON_NOT_FOUND);
	}

	@Test
	public void testWorkerLogin() {
	    assertEquals(CUT.workerLogin(), TRLReturnType.SUCCESS);
	}

	@Test
	public void testGetPatronID() {
	    assertEquals(CUT.getPatronID(), PatronID);
	    assertNotEquals(CUT.getPatronID(), BadPatronID);
	}

	@Test
	public void testGetPatronInfo() {
		assertEquals(CUT.getPatronInfo(), "Patron ID: P5\nName: Alice\nBooks Borrowing: []\nHolds: []\n");
		assertEquals(CUT.getPatronInfo(PatronID), "Patron ID: P5\nName: Alice\nBooks Borrowing: []\nHolds: []\n");
	}

	@Test
	public void testGetCopyInfo() {
		assertEquals(CUT.getCopyInfo("C5"), "Copy ID: C5\nTitle: Design Patterns\nChecked Out To: (Not Checked Out)\n");
	}

	@Test
	public void testGetCanCheckOut() {
	    assertTrue(CUT.getCanCheckOut());

	}
}
