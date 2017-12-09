package gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GUImain {

	private Integer SCREEN_HEIGHT = 80; 
	private Integer SCREEN_WIDTH = 80; 
	private GUImenu mainMenu;
	
	private BufferedReader br;
	
	public GUImain(){
		mainMenu = new GUImenu();
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void clearScreen(){
		for(int i = 0; i < SCREEN_HEIGHT; i++){
			System.out.println("\n");
		}
	}	
	
	public void displayMainMenu(){
		mainMenu.display();
	}
	
	public String getUserInput() throws IOException{
		System.out.print("> ");
		return br.readLine();
	}
	
	public void pauseContinue() throws IOException{
		System.out.println("Press any key to continue.\n");
		br.readLine();
	}
}
