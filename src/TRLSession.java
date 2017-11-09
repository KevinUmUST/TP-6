/**
 *	TRLSession 
 * 
 *  Manages sessions (transactions) between the TRL operator and the given 
 *  patron.
 *  
 *  @author 
 *
 */
public class TRLSession {

	private TRLSystem TRLSystem;
	private String sessionPatronID;
	private boolean canCheckOut;
	
	TRLSession(String patronID){
		TRLSystem = new TRLSystem();
		sessionPatronID = patronID;
		canCheckOut = TRLSystem.canCheckOut(patronID);
	}

	public String checkOutCopy(String patronID, String copyID){
		return "";
	}
	
}
