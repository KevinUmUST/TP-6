package tgui;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gui.GUImenuItem;

public class GUImenuItemTest {

	GUImenuItem CUT; // Class Under Test
	
	@Before
	public void setUp() throws Exception {
		CUT = new GUImenuItem(1, "name");
	}

	@Test
	public void getset_test() {
		assert(CUT.getName().equals("name"));
		assert(CUT.getID() == 1);
	}

}
