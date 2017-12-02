import static org.junit.Assert.*;

import org.junit.Test;

public class TRLSessionTest {

	TRLSession CUT;		// Class Under Test
	String PatronID = "P1";
	String CopyID	= "C1";
	String BadPatronID = "XP1";
	String BadCopyID   = "XC1";
	
	public TRLSessionTest() throws Exception{
		CUT = new TRLSession("PatronID");
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
	    assertEquals(CUT.getPatronID(), BadPatronID);
	}

	@Test
	public void testGetPatronInfoString() {
		//System.out.println(CUT.getPatronInfo());
	}

	@Test
	public void testGetPatronInfo() {
	    assertTrue("should be same", true);

	}

	@Test
	public void testGetCopyInfo() {
	    assertTrue("should be same", true);

	}

	@Test
	public void testGetCanCheckOut() {
	    assertTrue("should be same", true);

	}

}
