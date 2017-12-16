package trl;
/**
 *  TRLLibrary
 *  
 *  Contains the directory of textbooks, copies, and patrons associated
 *  with the library.
 *  
 * @author Kevin Um
 * @author Justin Siu-Ting Hui
 * @author Sheng Lor
 * 
 * @date December 16, 2017
 *
 */
import java.util.HashMap;
import java.util.Iterator;
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
		patronStore.put("P2", new Patron("P2", "McLate"));
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
		getPatron("P2").checkCopyOut(getCopy("C1"));
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
	
	/**
	 *  checkIn
	 * 
	 *  checks in a patron's held copy
	 *  
	 * @param patronID
	 * @param copyID
	 * @return
	 */
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
		if(getPatron(patronID) == null)
			return false;
		return (getPatron(patronID).numHolds() != 0);
	}
	
	/**
	 *  hasCopy
	 *  
	 * @param patronID
	 * @return true if patron has copy checked out; false otherwise
	 */
	public static boolean hasCopy(String patronID) {
		return (getPatron(patronID).numCheckedOutCopies()!=0);
	}

	/**
	 * runInventoryReport
	 * 
	 * gives the list of missing books and other important statistics for the
	 * past year.  These statistics include number and value of copies added to
	 * inventory, number and value of copies sold to students, number and value
	 * of copies withdrawn, and total number and value of all copies in current
	 * Rental inventory. 
	 * 
	 */
	public static void runInventoryReport(){
	
		int num = 0;
		int numHolds = 0;
		int numPatronHolds = 0;
		int numPatrons = patronStore.size();
		int numCopies  = copyStore.size();
		
		System.out.println("===========================================================");
		System.out.println("              TEXTBOOK RENTAL LIBRARY");
		System.out.println("                  INVENTORY REPORT");
		System.out.println("===========================================================");

		System.out.println("\n");
		System.out.println("	STATISTICS");
		System.out.println("===========================================================");
		
		System.out.println("Total Number of Copies: " + numCopies);
		System.out.println("Total Number of Patrons: " + numPatrons);
		System.out.println("");
		System.out.println("Patrons with holds: " + numPatronHolds + "/" + numPatrons);
		System.out.println("Copies Overdue: " + numHolds + "/" + numCopies);
		System.out.println("");
	
		System.out.println("\n");
		System.out.println("	PATRON INFORMATION");
		System.out.println("===========================================================");
		Iterator it	= patronStore.entrySet().iterator();
		System.out.println("Patron\tName\tID\tChecked Out\tHolds\n");
		while (it.hasNext()) {
	        Map.Entry<String, Patron> pair = (Map.Entry<String, Patron>)it.next();
	        System.out.println( pair.getKey() + "\t" +
								pair.getValue().getName() + "\t" +
								pair.getValue().getPatronID() + "\t" +
								pair.getValue().numCheckedOutCopies() + "\t\t" +
								pair.getValue().numHolds());
	        if((num = pair.getValue().numHolds()) > 0){
	        	numHolds += num;
	        	numPatronHolds++;
	        }
	    }
		
		System.out.println("\n");
		System.out.println("	COPY INFORMATION");
		System.out.println("===========================================================");
		it	= copyStore.entrySet().iterator();
		System.out.println("Copy\tOut To\tID\tTitle\n");
		while (it.hasNext()) {
	        Map.Entry<String, Copy> pair = (Map.Entry<String, Copy>)it.next();
	        String outTo;
	        if (pair.getValue().getOutTo() == null)
	        	outTo = "N/A";
	        else outTo = pair.getValue().getOutTo().getName();
	        System.out.println( pair.getKey() + "\t" + 
								outTo + "\t" +
								pair.getValue().getCopyID() + "\t" +
								pair.getValue().getTitle());
	    }
		
		System.out.println("\n");
		System.out.println("	MISSING COPIES");
		System.out.println("===========================================================");
		it	= copyStore.entrySet().iterator();
		System.out.println("Copy\tOut To\tID\tTitle\n");
		while (it.hasNext()) {
	        Map.Entry<String, Copy> pair = (Map.Entry<String, Copy>)it.next();
	        String outTo;
	        if (pair.getValue().getOutTo() == null){
	        	break;
	        }
	        else {
	        	outTo = pair.getValue().getOutTo().getName();
	        	System.out.println( pair.getKey() + "\t" + 
								outTo + "\t" +
								pair.getValue().getCopyID() + "\t" +
								pair.getValue().getTitle());
	        }
	    }
	}
}