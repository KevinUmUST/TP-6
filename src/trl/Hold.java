package trl;

/**
 * Hold
 * 
 * Describes the hold class which manages an individual hold against a patron
 * for a specific copy being late.
 * 
 * @author Kevin Um
 * @author Justin Siu-Ting Hui
 * @author Sheng Lor
 * 
 * @date December 16, 2017
 *
 */
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
