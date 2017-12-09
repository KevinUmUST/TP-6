package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * TRLApp Test Suite
 * 
 * Textbook Rental Library Application 
 * Test Suite Code
 * 
 * SEIS 635 Group Project
 * Professor: Eric Level
 * 
 * This application implements a textbook rental library that keeps track of 
 * transactions between the library and its patrons. The application provides
 * logic to support a library attendant managing library assets and 
 * transactions with customers.
 * 
 * These tests cover all trl and gui package contents.
 * 
 * For more information see the project specifications in the /doc.
 * 
 * @author Kevin Um
 * @author Justin Siu-Ting Hui
 * @author Sheng Lor
 * 
 * @date December 16, 2017
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ test_trl.CopyTest.class, test_trl.HoldTest.class, test_trl.PatronTest.class, test_trl.TRLLibraryTest.class, test_trl.TRLSessionTest.class,
		test_trl.TRLSystemTest.class, test_gui.GUImenuTest.class, test_gui.GUImainTest.class })
	public class AllTests {

}
