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
	private boolean workerValidated = false; 
	
	TRLSession(String patronID){
		TRLSystem = new TRLSystem();
		sessionPatronID = patronID;
		canCheckOut = TRLSystem.canCheckOut(patronID);
	}

	public TRLReturnType checkOutCopy(String patronID, String copyID){
		return TRLSystem.checkOut(patronID, copyID);
	}
	
	public TRLReturnType WorkerLogin(){
		return TRLReturnType.SUCCESS;
	}
	
	public String getPatronID(){
		return sessionPatronID;
	}
}
