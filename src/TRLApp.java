import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TRLApp {

	// Refactor this to use the GUI definitions of menu IDs.....
	static final int QUIT = 3;
	static final int CHECK_OUT = 1;
	static final int PATRON_INFO = 2;
	
	private static GUImain gui;
	private static TRLSession session;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		gui = new GUImain();
		init();
		session = new TRLSession(requestPatronID());
		gui.clearScreen();
		runMainMenu();

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
		TimeUnit.SECONDS.sleep(3);	
		//gui.clearScreen();
	}
	
	private static String requestPatronID() throws IOException{
		System.out.println("Please enter the Patron's ID.");
		String id = gui.getUserInput();
		// Validate id...
		return id;
	}
	
	private static String requestCopyID() throws IOException{
		System.out.println("Please enter the Copy ID.");
		String id = gui.getUserInput();
		// Validate id...
		return id;
	}
	
	private static String menuDisplayGetResponse() throws IOException{
		gui.displayMainMenu();
		return gui.getUserInput();
	}

	private static boolean validateMainMenuCmd(String s){
		int NUM_MENU_ITEMS = 2; // Refactor this out to top or GUI
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
			if(validateMainMenuCmd(cmdStr = menuDisplayGetResponse())){
				cmdInt = Integer.parseInt(cmdStr);
			}
			else return;
			
			switch(cmdInt){
				case QUIT:
					break;
				case CHECK_OUT:
					gui.clearScreen();
					System.out.println("Check Out\n\n");
					session.checkOutCopy(session.getPatronID(), requestCopyID());
					gui.pauseContinue();
					gui.clearScreen();
					break;
				case PATRON_INFO:
					gui.clearScreen();
					System.out.println("Patron Account Information \n\n");
					System.out.println(session.getPatronInfo());
					gui.pauseContinue();
					gui.clearScreen();
			}
		}
	}

}
