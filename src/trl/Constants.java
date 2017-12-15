package trl;

final public class Constants {
	public static final int CHECK_IN = 1;
	public static final int CHECK_OUT = 2;
	public static final int PATRON_INFO = 3;
	public static final int HELP = 4;
	public static final int QUIT = 5;
	public static final int NUM_MENU_ITEMS = 5;
	
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
}
