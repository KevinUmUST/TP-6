package test_trl;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trl.Patron;
import trl.TRLReturnType;
import trl.TRLSystem;

/**
 * TRLSystemTest
 * 
 * TRLSystem Class Test
 * 
 * @author Kevin Um
 * @author Justin Siu-Ting Hui
 * @author Sheng Lor
 * 
 * @date December 16, 2017
 *
 */
public class TRLSystemTest { 
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
	public void checkOutInSuccess(){
		assertEquals(trlSystem.checkOut("P1", "C3"), TRLReturnType.SUCCESS);
		assertEquals(trlSystem.checkIn("P1", "C3"), TRLReturnType.SUCCESS);
	}
	
	@Test
	public void checkOutInError(){
		assertEquals(trlSystem.checkOut("X1", "C3"), TRLReturnType.PATRON_NOT_FOUND);
		assertEquals(trlSystem.checkIn("P1", "X3"), TRLReturnType.COPY_NOT_FOUND);
		assertEquals(trlSystem.checkIn("P1", "C3"), TRLReturnType.UNKNOWN_ERROR);
	}
	
	@Test
	public void validatingPatronIdNotExist() throws Exception {
		
		TRLReturnType result=trlSystem.checkPatronID("P100"); //P100 does not exist in TRLLibrary
		
		assertEquals(TRLReturnType.PATRON_NOT_FOUND,result);
	}
	
	@Test
	public void canCheckInTest () {
		assert(trlSystem.canCheckIn("P2"));
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
