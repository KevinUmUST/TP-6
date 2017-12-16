package trl;

final public class Constants {
	public static final int CHECK_IN = 1;
	public static final int CHECK_OUT = 2;
	public static final int PATRON_INFO = 3;
	public static final int HELP = 4;
	public static final int INVENTORY_REPORT = 5;
	public static final int QUIT = 6;
	public static final int NUM_MENU_ITEMS = 6;
	
	public static final String mainHeader = 
			 ("***********************************************\n"
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
	
	public static final String invalidPatronIDMessage = 
			"\nInvalid Patron ID. Please try again.\n";
	
	public static final String invalidCopyIDMessage = 
			"\nInvalid Copy ID. Please try again.\n";
	
	public static final String helpDoc = ("Help Documentation\n\n" + 
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
					"ID = C10 (Pro Git)\n\n\n" + 
					
					" MAIN MENU: Please enter your selection: \n " + 
					" 1. CHECK IN \n " + 
					" 2. CHECK OUT \n " +
					" 3. PATRON ACCOUNT INFO \n " +
					" 4. QUIT \n \n " +
					"To check in or return a copy, press 1 \n " +
					"To check out or borrow a copy, press 2 \n " +
					"To see your account information (i.e. holds), press 3 \n " +
					"To quit, press 4 \n\n\n " +
					
					"If press 1 ------> Type in the ID number of the copy that you have checked out \n " +
					"	*System will say SUCCESS when check in is completed \n " +
					"If press 2 ------> Type in the ID number of an available copy (available copy's info are at the top) \n " +	
					"	*System will say SUCCESS if check out is completed, or it will say FAIL if there is a hold in your account \n " +
					"If press 3 ------> You will see your account information \n " +		
					"If press 4 ------> Quit \n" );
}
