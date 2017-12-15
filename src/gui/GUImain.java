package gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * GUImain
 * 
 * implements the main GUI interface for the TRLApp.
 * 
 * @author Kevin Um
 * @author Justin Siu-Ting Hui
 * @author Sheng Lor
 * 
 * @date December 16, 2017
 */
public class GUImain {

	private Integer SCREEN_HEIGHT = 80; 
	private GUImenu mainMenu;
	
	private BufferedReader br;
	
	/**
	 *  GUImain
	 *  
	 *  Constructor
	 */
	public GUImain(){
		mainMenu = new GUImenu();
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	/**
	 * clearScreen
	 * 
	 * Clears screen by writing many new lines.
	 * 
	 */
	public void clearScreen(){
		for(int i = 0; i < SCREEN_HEIGHT; i++){
			System.out.println("\n");
		}
	}	
	
	/**
	 *  displayMainMenu
	 *  
	 *  Uses a menu object to display the menu's items in a formatted manner.
	 *  
	 */
	public void displayMainMenu(){
		mainMenu.display();
	}
	
	/**
	 * getUserInput
	 * 
	 * @return Return user input data.
	 * @throws IOException
	 */
	public String getUserInput() throws IOException{
		System.out.print("> ");
		return br.readLine();
	}
	
	/**
	 * pauseContinue
	 * 
	 * pauses operation and waits for user input to continue.
	 * 
	 * @throws IOException
	 */
	public void pauseContinue() throws IOException{
		System.out.println("Press any key to continue.\n");
		br.readLine();
	}
}
