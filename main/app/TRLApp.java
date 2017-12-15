package app;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import gui.GUImain;
import trl.Constants;
import trl.TRLReturnType;
import trl.TRLSession;

/**
 * TRLApp
 * 
 * Textbook Rental Library Application
 * 
 * SEIS 635 Group Project
 * Professor: Eric Level
 * 
 * This application implements a textbook rental library that keeps track of 
 * transactions between the library and its patrons. The application provides
 * logic to support a library attendant managing library assets and 
 * transactions with customers.
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
public class TRLApp {
	private static GUImain gui;
	private static TRLSession session;
	
	/**
	 * main
	 * 
	 * Main entry into the Textbook Rental Library application (TRLApp).
	 * 
	 * @param args						None
	 * 
	 * @throws IOException				Invalid user input data.
	 * @throws InterruptedException		OS interrupted execution.
	 * 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		gui = new GUImain();
		init();
		while(true){
			boolean notdone = true;
			System.out.println("Starting New TRL Session...\n");
			while(notdone){
				try {
					System.out.println("Please enter the Patron's ID.");
					session = new TRLSession(gui.getUserInput());
					notdone = false;
				}
				catch (Exception e){
					System.out.println(Constants.invalidPatronIDMessage);
				}
			}
			gui.clearScreen();
			System.out.println("Patron Account Information \n\n");
			System.out.println(session.getPatronInfo());
			gui.pauseContinue();
			gui.clearScreen();
			runMainMenu();
			gui.clearScreen();
		}
	}

	/**
	 * init
	 * 
	 * Performs initialization and displays splash screen for TRLApp.
	 * 	 
	 * @throws InterruptedException
	 */
	private static void init() throws InterruptedException{
		System.out.println(Constants.mainHeader);
		TimeUnit.SECONDS.sleep(1);	
	}
	
	/**
	 * @return
	 * @throws IOException
	 */
	private static String requestCopyID() throws IOException{
		System.out.println("Please enter the Copy ID.");
		String id = gui.getUserInput();
		// Validate id...
		return id;
	}

	/**
	 * 	displayPatronIDandWarnings
	 * 
	 *  Displays the currently set Patron's ID and any warnings about them such
	 *  as  whether there are holds on the account.	
	 *  
	 */
	private static void displayPatronIDandWarnings(){
		System.out.println("PatronID: " + session.getPatronID());
		if(!session.getCanCheckOut()){
			System.out.println("WARNING! Customer has holds on their account!\n");
		}
	}
	
	/**
	 * 	displayMenuGetResponse
	 *
	 * 	Display main menu and request user input for menu item selection.
	 * 
	 * @return	User menu selection value.
	 * 
	 * @throws IOException
	 */
	private static String displayMenuGetResponse() throws IOException{
		displayPatronIDandWarnings();
		gui.displayMainMenu();
		return gui.getUserInput();
	}

	/**
	 * 	validateMainMenuCmd
	 * 
	 * @param Input string of user's menu selection value.
	 * 
	 * @return True when the value is valid.
	 */
	private static boolean validateMainMenuCmd(String s){
		try
		{
			int cmd = Integer.parseInt(s);
			return (cmd <= Constants.NUM_MENU_ITEMS);
		}
		catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * 	runMainMenu
	 * 
	 * 	Runs the application's main menu in a loop.
	 * 
	 * @throws IOException
	 */
	private static void runMainMenu() throws IOException{
		String cmdStr;
		int cmdInt = 1;
		
		while(cmdInt != Constants.QUIT){
			cmdInt = validateMainMenuCmd(cmdStr = displayMenuGetResponse()) ?
					Integer.parseInt(cmdStr) : -1;
			switch(cmdInt){ // TODO: Fix code smell - remove common code from case statements and place after case block
				case Constants.CHECK_IN:
					gui.clearScreen();
					System.out.println("Check In\n\n");
					if(!session.getCanCheckIn()) {
						System.out.println("Customer has no checked out " + 
										   "copies! Cannot perform check in.\n");
					}
					else {
						while(session.checkInCopy(session.getPatronID(), 
								requestCopyID()) != TRLReturnType.SUCCESS){
						gui.clearScreen();
						System.out.println("Check In\n\n");
						System.out.println(Constants.invalidCopyIDMessage);
						}
					}
					break;
				case Constants.QUIT:
					System.out.println("Exiting current session...\n");
					break;
				case Constants.CHECK_OUT:
					gui.clearScreen();
					System.out.println("Check Out\n\n");
					if(!session.getCanCheckOut()){
						System.out.println("Customer has holds! Cannot perform check out.\n");
					}
					else{
						while(session.checkOutCopy(session.getPatronID(), 
								requestCopyID()) != TRLReturnType.SUCCESS){
							gui.clearScreen();
							System.out.println("Check Out\n\n");
							System.out.println(Constants.invalidCopyIDMessage);
						}
					}
					break;
				case Constants.PATRON_INFO:
					gui.clearScreen();
					System.out.println("Patron Account Information \n\n");
					System.out.println(session.getPatronInfo());
					break;
				case Constants.HELP: 
					gui.clearScreen();
					System.out.println(Constants.helpDoc);
					break;
				default:
					gui.clearScreen();
					System.out.println("Invalid menu item, please try again.\n");
					break;
			}
			gui.pauseContinue();
			gui.clearScreen();
		}
	}
}
