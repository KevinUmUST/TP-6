/**
 *  TRLLibrary
 *  
 *  Contains the directory of textbooks, copies, and patrons associated
 *  with the library.
 *  
 *  @author
 *  
 */
import java.util.HashMap;
import java.util.Map;

public class TRLLibrary {

	private static Map<String, Patron> patronStore;
	private static Map<String, Copy> copyStore;

	/**
	 * 	Static Initialization
	 */
	static
	{
		patronStore = new HashMap<String, Patron>();
		copyStore = new HashMap<String, Copy>();

		patronStore.put("P1", new Patron("P1", "Eric"));
		patronStore.put("P2", new Patron("P2", "Latey McLateFace"));
		patronStore.put("P3", new Patron("P3", "John"));
		patronStore.put("P4", new Patron("P4", "Sarah"));
		patronStore.put("P5", new Patron("P5", "Alice"));

		
		copyStore.put("C1", new Copy("C1", "Fun with Objects"));
		copyStore.put("C2", new Copy("C2", "More Fun with Objects"));
		copyStore.put("C3", new Copy("C3", "Clean Code"));
		copyStore.put("C4", new Copy("C4", "The Mythical Man-Month"));
		copyStore.put("C5", new Copy("C5", "Design Patterns"));
		copyStore.put("C6", new Copy("C6", "Software Engineering"));
		copyStore.put("C7", new Copy("C7", "Agile Principles"));
		copyStore.put("C8", new Copy("C8", "Repaid Development"));
		copyStore.put("C9", new Copy("C9", "Beautiful Code"));
		copyStore.put("C10", new Copy("C10", "Pro Git"));

		
		getPatron("P2").addHold(new Hold(getCopy("C1")));
	}

	/**
	 * 	getPatron
	 * 	Returns a Patron object for a given patron ID.
	 * 
	 * @param patronID
	 * @return Patron object.
	 */
	public static Patron getPatron(String patronID)
	{
		return patronStore.get(patronID);
	}

	/**
	 *  getCopy
	 *  Returns a Copy object for a given copy ID.
	 *  
	 * @param copyID
	 * @return
	 */
	public static Copy getCopy(String copyID)
	{
		return copyStore.get(copyID);
	}

	/**
	 *	checkOut 
	 *	Performs a check out operation, checking out a library copy to a
	 *	patron.
	 *
	 * @param patronID
	 * @param copyID
	 * @return
	 */
	public static boolean checkOut(String patronID, String copyID){
		Patron p = getPatron(patronID);
		Copy c = getCopy(copyID);
		
		if(p.checkCopyOut(c)){
			c.setOutTo(p);
			return true;
		}
		else return false;
	}
	
	public static boolean checkIn(String patronID, String copyID) {
		Patron p = getPatron(patronID);
		Copy c = getCopy(copyID);
		
		if(p.checkCopyIn(c)) {
			c.setOutTo(null);
			return true;
		}
		else return false;
		
	}

	/**
	 * 	hasHold
	 *  Checks whether or not a patron has a hold on their account.
	 *  
	 * @param 	patronID
	 * @return 				true if Patron has a hold
	 * 						false if Patron does not have a hold
	 */
	public static boolean hasHold(String patronID){
		return (getPatron(patronID).numHolds() != 0);
	}
	

}
