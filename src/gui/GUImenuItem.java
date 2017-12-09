package gui;

/**
 * GUImenuItem
 * 
 * implements a menu item class for the menu class.
 * 
 * @author Kevin Um
 * @author Justin Siu-Ting Hui
 * @author Sheng Lor
 * 
 * @date December 16, 2017
 */
/**
 * @author Ghost-IV
 *
 */
public class GUImenuItem {
	private String name;
	private int id;
	
	/**
	 * GUImenuItem
	 * 
	 * constructor
	 * 
	 * @param id	numeric id
	 * @param name	name of the menu item which is displayed in the menu
	 */
	public GUImenuItem(int id, String name){
		this.name = name;
		this.id = id;
	}

	/**
	 * getName
	 * 
	 * get the menu name value
	 * 
	 * @return	name value
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * getID
	 * 
	 * get the ID value
	 * 
	 * @return	ID value
	 */
	public int getID(){
		return id;
	}
}
