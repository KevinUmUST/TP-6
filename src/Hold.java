
public class Hold {

	private Copy lateCopy;
	private int daysOverdue = 0; 		// TODO: Implement this functionality
	
	public Hold(Copy c){
		lateCopy = c;
	}
	
	public Copy getCopy(){
		return lateCopy;
	}
	
	public String toString(){
		return "HOLD\nLate Copy: " + lateCopy.getTitle() + "\nDays Overdue: " + daysOverdue +
				"\n";
	}
}
