import java.util.ArrayList;

public class GUImenu {

	public final int SEPARATOR_LENGTH = 47;
	private ArrayList<GUImenuItem> menuItems = new ArrayList<GUImenuItem>();
	
	public GUImenu(){
		menuItems.add(new GUImenuItem(1, "CHECK IN"));
		menuItems.add(new GUImenuItem(2, "CHECK OUT"));
		menuItems.add(new GUImenuItem(3, "PATRON ACCOUNT INFO"));
		menuItems.add(new GUImenuItem(4, "QUIT"));
	}
	
	public void display(){
		printHeader("MAIN MENU");
		for (GUImenuItem menuItem : menuItems){
			System.out.println(menuItem.getID() + ". " + menuItem.getName());
		}
		printSeparator();
	}
	
	public void addMenuItem(GUImenuItem menuItem){
		menuItems.add(menuItem);
	}
	
	public void removeMenuItem(GUImenuItem menuItem){
		menuItems.remove(menuItem);
	}
	
	public void printSeparator(){
		for(int i=0;i<SEPARATOR_LENGTH;i++){
			System.out.print("*");
		}
		System.out.println("\n");
	}
	
	public void printHeader(String s){
		printSeparator();
		for(int i=0;i<SEPARATOR_LENGTH/3+1;i++){
			System.out.print(" ");
		}
		System.out.print(s + "\n");
		printSeparator();
		System.out.println("Please enter your selection.\n");
	}
	
}
