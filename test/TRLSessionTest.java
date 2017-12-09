import static org.junit.Assert.*;

import org.junit.Test;

public class TRLSessionTest {

	TRLSession CUT;		// Class Under Test
	String PatronID = "P1";
	String CopyID	= "C1";
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
		assertEquals(CUT.getPatronInfo(), "Patron ID: P1\nName: Eric\nBooks Borrowing: []\nHolds: []\n");
		assertEquals(CUT.getPatronInfo(PatronID), "Patron ID: P1\nName: Eric\nBooks Borrowing: []\nHolds: []\n");
	}

	@Test
	public void testGetCopyInfo() {
		assertEquals(CUT.getCopyInfo("C1"), "Copy ID: C1\nTitle: Fun with Objects\nChecked Out To: (Not Checked Out)\n");
	}

	@Test
	public void testGetCanCheckOut() {
	    assertTrue(CUT.getCanCheckOut());

	}
}
