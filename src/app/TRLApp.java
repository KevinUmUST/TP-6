package app;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import gui.GUImain;
import trl.Copy;
import trl.Patron;
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

	// Refactor this to use the GUI definitions of menu IDs.....
	static final int CHECK_IN = 1;
	static final int CHECK_OUT = 2;
	static final int PATRON_INFO = 3;
	static final int HELP = 4;
	static final int QUIT = 5;
	static final int NUM_MENU_ITEMS = 5; // Refactor this out to top or GUI
	
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
					System.out.println("\nInvalid Patron ID. Please try again.\n");
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
	private static void init() throws InterruptedException{ // TODO: CodeSmell: Move Constant String values to a common location
		System.out.println("***********************************************\n"
				+ "            TEXTBOOK RENTAL SYSTEM\n"
				+ "***********************************************\n"
				+ "\n"
				+ "  SEIS 635 Group Project\n"
				+ "  December 2017\n\n"
				+ "  Written by:\n"
				+ "  Sheng Lor, Justin Siu-Ting Hui, and Kevin Um\n"
				+ "\n"
				+ "\n"
				+ "  Professor: Eric Level\n"
				+ "\n\n"
				+ "***********************************************\n"
				+ "\n\n"
				+ "Starting textbook rental system..."
				+ "\n\n");
		TimeUnit.SECONDS.sleep(1);	
		//gui.clearScreen(); // TODO: Get rid of this if not necessary
	}

	
	/**
	 * 	requestPatronID
	 * 
	 * @return	Returns the Patron ID supplied by the user if the user provided
	 *  		a valid ID.
	 * 
	 * @throws IOException
	 */
	private static String requestPatronID() throws IOException{
		System.out.println("Please enter the Patron's ID.");
		String id;
		while(!session.validatePatron(id = gui.getUserInput())){
			System.out.println("Invalid Patron ID. Please try again.\n");
		}
		return id;
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
			return (cmd <= NUM_MENU_ITEMS);
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
		
		while(cmdInt != QUIT){
			cmdInt = validateMainMenuCmd(cmdStr = displayMenuGetResponse()) ?
					Integer.parseInt(cmdStr) : -1;
			
			switch(cmdInt){ // TODO: Fix code smell - remove common code from case statements and place after case block
				case CHECK_IN:
					gui.clearScreen();
					System.out.println("Check In\n\n");
					
					if(!session.getCanCheckIn()) {
						System.out.println("Customer has no checked out copies! Cannot perform check in.\n");
					}
					else {
						while(session.checkInCopy(session.getPatronID(), requestCopyID()) != TRLReturnType.SUCCESS){
						gui.clearScreen();
						System.out.println("Check In\n\n");
						System.out.println("Invalid Copy ID. Please try again.\n");
						}
					}
					gui.pauseContinue();
					gui.clearScreen();
					break;

				case QUIT:
					gui.clearScreen();
					break;
					
				case CHECK_OUT:
					gui.clearScreen();
					System.out.println("Check Out\n\n");
					if(!session.getCanCheckOut()){
						System.out.println("Customer has holds! Cannot perform check out.\n");
					}
					else{
						while(session.checkOutCopy(session.getPatronID(), requestCopyID()) != TRLReturnType.SUCCESS){
							gui.clearScreen();
							System.out.println("Check Out\n\n");
							System.out.println("Invalid Copy ID. Please try again.\n");
						}
					}
					gui.pauseContinue();
					gui.clearScreen();
					break;
					
				case PATRON_INFO:
					gui.clearScreen();
					System.out.println("Patron Account Information \n\n");
					System.out.println(session.getPatronInfo());
					gui.pauseContinue();
					gui.clearScreen();
					break;
				case HELP: 
					gui.clearScreen();
					System.out.println("Help Documentation\n\n" + 
					"Avaliable Patron: \n" +
							"ID = P1 (Eric)\n" +
							"ID = P2 (Laey McLateFace)\n" +
							"ID = P3 (John)\n" +
							"ID = P4 (Sarah)\n" +
							"ID = P5 (Alice)\n\n\n" + 
					
					"Avaliable Copies: \n" +
					"ID = C1 (Fun with Objects)\n" +
					"ID = C2 (More Fun with Objects)\n" +
					"ID = C3 (Clean Code)\n" +
					"ID = C4 (The Mythical Man-Month)\n" +
					"ID = C5 (Design Patterns)\n" +
					"ID = C6 (Software Engineering)\n" +
					"ID = C7 (Agile Principles)\n" +
					"ID = C8 (Repaid Development)\n" +
					"ID = C9 (Beautiful Code)\n" +
					"ID = C10 (Pro Git)\n" );
					

					gui.pauseContinue();
					gui.clearScreen();
					break;
				default:
					gui.clearScreen();
					System.out.println("Invalid menu item, please try again.\n");
					gui.pauseContinue();
					break;
			}
		}
	}

}