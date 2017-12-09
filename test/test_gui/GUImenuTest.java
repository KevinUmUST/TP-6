package test_gui;

import org.junit.Before;
import org.junit.Test;
import gui.GUImenu;
import gui.GUImenuItem;

/**
 * GUImenuTest
 * 
 * GUImenu Class Test
 * 
 * @author Kevin Um
 * @author Justin Siu-Ting Hui
 * @author Sheng Lor
 * 
 * @date December 16, 2017
 *
 */
public class GUImenuTest {

	GUImenu CUT;
	
	/**
	 * setUp
	 * 
	 * performs setup operations for the test
	 * 
	 * @throws Exception when unable to contruct GUImenuItem
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		CUT = new GUImenu(); 		// Class under test
	}

	/**
	 * printTest
	 * 
	 * Test printing operations of the class.
	 */
	@Test
	public void printTest(){
		CUT.printSeparator();
		CUT.printHeader("");
		CUT.display();
	}
	
	/**
	 * menuItemTest
	 * 
	 * Tests adding and removing menu items in the class.
	 */
	@Test
	public void menuItemTest(){
		CUT.addMenuItem(new GUImenuItem(0, "TEST"));
		CUT.removeMenuItem(new GUImenuItem(0, "TEST"));
	}
	

}
