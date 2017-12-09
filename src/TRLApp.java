import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TRLApp {

	// Refactor this to use the GUI definitions of menu IDs.....
	static final int CHECK_IN = 1;
	static final int CHECK_OUT = 2;
	static final int PATRON_INFO = 3;
	static final int QUIT = 4;
	static final int NUM_MENU_ITEMS = 4; // Refactor this out to top or GUI
	
	private static GUImain gui;
	private static TRLSession session;
	
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

	private static void init() throws InterruptedException{
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
		//gui.clearScreen();
	}
	
	private static String requestPatronID() throws IOException{
		System.out.println("Please enter the Patron's ID.");
		String id;
		while(!session.validatePatron(id = gui.getUserInput())){
			System.out.println("Invalid Patron ID. Please try again.\n");
		}
		return id;
	}
	
	private static String requestCopyID() throws IOException{
		System.out.println("Please enter the Copy ID.");
		String id = gui.getUserInput();
		// Validate id...
		return id;
	}
	
	private static void displayPatronIDandWarnings(){
		System.out.println("PatronID: " + session.getPatronID());
		if(session.getCanCheckOut()){
			System.out.println("WARNING! Customer has holds on their account!\n");
		}
	}
	
	private static String displayMenuGetResponse() throws IOException{
		displayPatronIDandWarnings();
		gui.displayMainMenu();
		return gui.getUserInput();
	}

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
	
	private static void runMainMenu() throws IOException{
		String cmdStr;
		int cmdInt = 1;
		
		while(cmdInt != QUIT){
			if(validateMainMenuCmd(cmdStr = displayMenuGetResponse())){
				cmdInt = Integer.parseInt(cmdStr);
			}
			else return;
			
			switch(cmdInt){
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
			}
		}
	}

}
