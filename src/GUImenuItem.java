import java.util.concurrent.Callable;

public class GUImenuItem {
	private String name;
	//private Callable handler;
	
	//public GUImenuItem(String name, Callable handler){
	public GUImenuItem(String name){
		this.name = name;
		//this.handler = handler;
	}
	
	public String getName(){
		return name;
	}
}
