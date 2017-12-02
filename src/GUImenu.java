import java.util.ArrayList;

public class GUImenu {

	public final int SEPARATOR_LENGTH = 47;
	private ArrayList<GUImenuItem> menuItems = new ArrayList<GUImenuItem>();
	
	public GUImenu(){
		menuItems.add(new GUImenuItem(1, "CHECK OUT"));
		menuItems.add(new GUImenuItem(2, "PATRON ACCOUNT INFO"));
		menuItems.add(new GUImenuItem(3, "QUIT"));
	}
	
	public void display(){
		printHeader("MAIN MENU");
		for (GUImenuItem menuItem : menuItems){
			System.out.println(menuItem.getID() + ". " + menuItem.getName());
		}
		printSeperator();
	}
	
	public void addMenuItem(GUImenuItem menuItem){
		menuItems.add(menuItem);
	}
	
	public void removeMenuItem(GUImenuItem menuItem){
		menuItems.remove(menuItem);
	}
	
	public void printSeperator(){
		for(int i=0;i<SEPARATOR_LENGTH;i++){
			System.out.print("*");
		}
		System.out.println("\n");
	}
	
	public void printHeader(String s){
		printSeperator();
		for(int i=0;i<SEPARATOR_LENGTH/3+1;i++){
			System.out.print(" ");
		}
		System.out.print(s + "\n");
		printSeperator();
		System.out.println("Please enter your selection.\n");
	}
	
}
