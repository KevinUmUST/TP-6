import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class GUImainTest {

	GUImain CUT = new GUImain();

	@Test
	public void test() {
		CUT.clearScreen();
		CUT.displayMainMenu();
	}
	public void getUserInputTest(){
		try {
			CUT.getUserInput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		try {
			CUT.pauseContinue();
		}
		catch (IOException e){
			fail();
		}
	}

}
