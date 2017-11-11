import java.util.concurrent.Callable;

public class GUImenuItem {
	private String name;
	private int id;
	//private Callable handler;
	
	//public GUImenuItem(String name, Callable handler){
	public GUImenuItem(int id, String name){
		this.name = name;
		this.id = id;
		//this.handler = handler;
	}
	
	public String getName(){
		return name;
	}
	
	public int getID(){
		return id;
	}
}
