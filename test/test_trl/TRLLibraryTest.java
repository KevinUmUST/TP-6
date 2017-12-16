package test_trl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import trl.TRLLibrary;

/**
 * TRLLibraryTest
 * 
 * TRLLibrary Class Test
 * 
 * @author Kevin Um
 * @author Justin Siu-Ting Hui
 * @author Sheng Lor
 * 
 * @date December 16, 2017
 *
 */
public class TRLLibraryTest {

	// Class Under Test is TRLLibrary (static)
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void getset_test() {
		assertEquals(TRLLibrary.getPatron("P1").getPatronID(), "P1");
		assertEquals(TRLLibrary.getCopy("C1").getCopyID(), "C1");
	}
	
	@Test
	public void checkout_test(){
		assertFalse(TRLLibrary.checkOut("P2", "C1"));
		assertTrue(TRLLibrary.checkIn("P2", "C1"));
	}



}
