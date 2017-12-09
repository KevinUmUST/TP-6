import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
		assertTrue(TRLLibrary.checkOut("P3", "C1"));
		TRLLibrary.checkIn("P3", "C1");
	}

}
