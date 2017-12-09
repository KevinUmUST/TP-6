package test_gui;

import org.junit.Before;
import org.junit.Test;
import gui.GUImenuItem;

/**
 * GUImenuItemTest
 * 
 * GUImenuItem Class Test
 * 
 * @author Kevin Um
 * @author Justin Siu-Ting Hui
 * @author Sheng Lor
 * 
 * @date December 16, 2017
 *
 */
public class GUImenuItemTest {

	GUImenuItem CUT; // Class Under Test
	
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
		CUT = new GUImenuItem(1, "name");
	}

	/**
	 * getset_test
	 * 
	 * Performs tests of the get and set operations 
	 * 
	 */
	@Test
	public void getset_test() {
		assert(CUT.getName().equals("name"));
		assert(CUT.getID() == 1);
	}

}
