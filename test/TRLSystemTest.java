import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TRLSystemTest {

	private Patron patron;
	private TRLSystem trlSystem;
	
	@Before
	public void setUp() throws Exception {
		trlSystem = new TRLSystem();
	}

	@Test
	public void validatingPatronIdExists() throws Exception {
		
		TRLReturnType result=trlSystem.checkPatronID("P1"); //P1 exists in TRLLibrary
		
		assertEquals(TRLReturnType.SUCCESS,result);
	}
	
	@Test
	public void validatingPatronIdNotExist() throws Exception {
		
		TRLReturnType result=trlSystem.checkPatronID("P100"); //P100 does not exist in TRLLibrary
		
		assertEquals(TRLReturnType.PATRON_NOT_FOUND,result);
	}

	
}
