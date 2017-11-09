import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class TRLApp {
	
	static BufferedReader br;
	public static void main(String[] args) throws IOException, InterruptedException {
		br = new BufferedReader(new InputStreamReader(System.in));
	
		init();
		TRLSession session = new TRLSession(requestPatronID());
		clearScreen();
		GUImain gui = new GUImain(session);

	}

	private static void init() throws InterruptedException{
		System.out.println("********************************************\n"
				+ "           TEXTBOOK RENTAL SYSTEM\n"
				+ "********************************************\n"
				+ "\n"
				+ "  SEIS 635 Group Project\n"
				+ "  December 2017\n\n"
				+ "  Written by:\n"
				+ "  Sheng Lor, Justin Siu-Ting Hui, and Kevin Um\n"
				+ "\n"
				+ "\n"
				+ "  Professor: Eric Level\n"
				+ "\n\n\n"
				+ "Starting textbook rental system..."
				+ "");
		TimeUnit.SECONDS.sleep(5);	
		clearScreen();
	}
	
	private static void clearScreen(){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	private static String requestPatronID() throws IOException{
		System.out.println("Please enter the Patron's ID.");
		String id = br.readLine();
		// Validate id...
		return id;
	}

}
