package gui;

import java.util.ArrayList;

/**
 * GUImenu
 * 
 * implements the GUI menu component for the main GUI interface.
 * 
 * @author Kevin Um
 * @author Justin Siu-Ting Hui
 * @author Sheng Lor
 * 
 * @date December 16, 2017
 */
public class GUImenu {

	public final int SEPARATOR_LENGTH = 47;
	private ArrayList<GUImenuItem> menuItems = new ArrayList<GUImenuItem>();
	
	/**
	 * GUImenu Constructor
	 */
	public GUImenu(){
		menuItems.add(new GUImenuItem(1, "CHECK IN"));
		menuItems.add(new GUImenuItem(2, "CHECK OUT"));
		menuItems.add(new GUImenuItem(3, "PATRON ACCOUNT INFO"));
		menuItems.add(new GUImenuItem(4, "QUIT"));
	}
	
	/**
	 * display
	 * 
	 * displays the menu in a formatted manner
	 * 
	 */
	public void display(){
		printHeader("MAIN MENU");
		for (GUImenuItem menuItem : menuItems){
			System.out.println(menuItem.getID() + ". " + menuItem.getName());
		}
		printSeparator();
	}
	
	/**
	 * addMenuItem
	 * 
	 * adds a menu item to the menu's list of options
	 * 
	 * @param menuItem 		new menu item to add to the menu
	 */
	public void addMenuItem(GUImenuItem menuItem){
		menuItems.add(menuItem);
	}
	
	/**
	 * removeMenuItem
	 *
	 * removes a menu item from a menu's list of options
	 * 
	 * @param menuItem
	 */
	public void removeMenuItem(GUImenuItem menuItem){
		menuItems.remove(menuItem);
	}
	
	/**
	 * printSeparator
	 * 
	 * prints a format separator line
	 */
	public void printSeparator(){
		for(int i=0;i<SEPARATOR_LENGTH;i++){
			System.out.print("*");
		}
		System.out.println("\n");
	}
	
	/**
	 * printHeader
	 * 
	 * prints a header in the GUI's format
	 * 
	 * @param s			string containing the header data
	 */
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
