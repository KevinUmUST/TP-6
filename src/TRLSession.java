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

	/**
	 *	checkOutCopy
	 *	Performs check out operation.
	 * 
	 * @param 	patronID
	 * @param 	copyID
	 * @return  
	 */
	public TRLReturnType checkOutCopy(String patronID, String copyID){
		return TRLSystem.checkOut(patronID, copyID);
	}

	/**
	 *	workerLogin
	 *	Validate the Worker using the system.
	 *  TODO: Implement this.
	 *  
	 * @return
	 */
	public TRLReturnType workerLogin(){
		return TRLReturnType.SUCCESS;
	}

	/**
	 *	getPatronID
	 *	Returns the Session Patron ID.  
	 *
	 * @return
	 */
	public String getPatronID(){
		return sessionPatronID;
	}

	/**
	 *	getPatronInfo 
	 *	Returns Patron information.
	 *
	 * @param patronID
	 * @return
	 */
	public String getPatronInfo(String patronID){
		return TRLSystem.getPatronInfo(patronID);
	}

	/**
	 *  getPatronInfo
	 *  Returns the Session Patron's information.
	 *  
	 * @return
	 */
	public String getPatronInfo(){
		return TRLSystem.getPatronInfo(sessionPatronID);
	}

	/**
	 *	getCopyInfo 
	 *	Returns a given Copy's information.
	 *
	 * @param copyID
	 * @return
	 */
	public String getCopyInfo(String copyID){
		return TRLSystem.getCopyInfo(copyID);
	}
}
