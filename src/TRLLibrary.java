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
	
	static
	{
		patronStore = new HashMap<String, Patron>();
		copyStore = new HashMap<String, Copy>();

		patronStore.put("P1", new Patron("P1", "Eric"));
		copyStore.put("C1", new Copy("C1", "Fun with Objects"));
		copyStore.put("C2", new Copy("C2", "More Fun with Objects"));
	}

	public static Patron getPatron(String patronID)
	{
		return patronStore.get(patronID);
	}

	public static Copy getCopy(String copyID)
	{
		return copyStore.get(copyID);
	}

	public static boolean checkOut(String patronID, String copyID){
		Patron p = getPatron(patronID);
		Copy c = getCopy(copyID);
		
		if(p.checkCopyOut(c)){
			c.setOutTo(p);
			return true;
		}
		else return false;
	}
	
	public static boolean hasHold(String patronID){
		return !(getPatron(patronID).numHolds() == 0);
	}
	

}
