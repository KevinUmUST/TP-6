package test_gui;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import gui.GUImain;

/**
 * GUImainTest
 * 
 * GUImain Class Test
 * 
 * @author Kevin Um
 * @author Justin Siu-Ting Hui
 * @author Sheng Lor
 * 
 * @date December 16, 2017
 *
 */
public class GUImainTest {

	GUImain CUT = new GUImain();

	/**
	 * test
	 * 
	 * main test that exercises the printing functions
	 * 
	 */
	@Test
	public void test() {
		CUT.clearScreen();
		CUT.displayMainMenu();
	}

	/**
	 * getUserInputTest
	 * 
	 * tests operations requiring user input
	 */
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
