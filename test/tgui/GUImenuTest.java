package tgui;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gui.GUImenu;
import gui.GUImenuItem;

public class GUImenuTest {

	GUImenu CUT = new GUImenu(); 		// Class under test
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void printTest(){
		CUT.printSeparator();
		CUT.printHeader("");
		CUT.display();
	}
	@Test
	public void menuItemTest(){
		CUT.addMenuItem(new GUImenuItem(0, "TEST"));
		CUT.removeMenuItem(new GUImenuItem(0, "TEST"));
	}
	

}
