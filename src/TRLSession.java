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
	private boolean canCheckIn;
	private boolean workerValidated = false; 

	/**
	 * 	Constructor
	 * 
	 * @param patronID
	 * @throws Exception 
	 */
	TRLSession(String patronID) throws Exception {
		TRLSystem = new TRLSystem();
		if(validatePatron(patronID)){
			sessionPatronID = patronID;
			canCheckOut = TRLSystem.canCheckOut(patronID);
			canCheckIn = TRLSystem.canCheckIn(patronID);
		}
		else throw new Exception();
	}

	/**
	 * 	validatePatron
	 * 	Validates a Patron ID to see if the account exists.
	 * 
	 * @param patronID
	 * @return
	 */
	public boolean validatePatron(String patronID){
		return (TRLSystem.checkPatronID(patronID) == TRLReturnType.SUCCESS);
	}
	
	/**
	 *  validateCopy
	 *  Validates a Copy ID to see if the copy exists in the library.
	 *
	 * @param copyID
	 * @return
	 */
	public boolean validateCopy(String copyID){
		return (TRLSystem.checkCopyID(copyID) == TRLReturnType.SUCCESS);
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
	
	public TRLReturnType checkInCopy(String patronID, String copyID) {
		return TRLSystem.checkIn(patronID, copyID);
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
	
	/**
	 * 	getCanCheckOut
	 *  Returns whether the session patron can check out copies.
	 *  
	 */
	public boolean getCanCheckOut(){
		return canCheckOut;
	}
	
	public boolean getCanCheckIn(){
		return TRLSystem.canCheckIn(sessionPatronID);

	}
	

}
