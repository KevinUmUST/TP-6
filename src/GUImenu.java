import java.util.ArrayList;

public class GUImenu {

	private ArrayList<GUImenuItem> menuItems = new ArrayList<GUImenuItem>();
	
	public GUImenu(){
		
	}
	
	public void display(){
		Integer count = 0;
		for (GUImenuItem menuItem : menuItems){
			System.out.println(count.toString() + ". " + menuItem.getName());
		}
	}
	
	public void addMenuItem(GUImenuItem menuItem){
		menuItems.add(menuItem);
	}
	
	public void removeMenuItem(GUImenuItem menuItem){
		menuItems.remove(menuItem);
	}
	
}
