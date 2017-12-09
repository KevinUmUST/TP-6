package ttrl;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trl.Patron;
import trl.TRLReturnType;
import trl.TRLSystem;

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
	
	@Test
	public void validatingCopyIdExists() throws Exception {
		
		TRLReturnType result=trlSystem.checkCopyID("C1"); //C1 exist in TRLLibrary
		
		assertEquals(TRLReturnType.SUCCESS,result);
	}
	
	@Test
	public void validatingCopyIdNotExist() throws Exception {
		
		TRLReturnType result=trlSystem.checkCopyID("C100"); //C100 does not exist in TRLLibrary
		
		assertEquals(TRLReturnType.COPY_NOT_FOUND,result);
	}

	
}
