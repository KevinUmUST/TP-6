package trl;
/**
 *	TRLSystem
 *	
 *	Implements the Textbook Rental Library (TRL) system functions.
 *	
 *	@author
 * 	@param	patronID	Optional. The string representation of the current
 * 						session's patron. 
 *
 */
import java.lang.String;

/**
 * TRLSystem 
 * 
 * TRL System level operations that are accessible to the application.
 * 
 * @author Kevin Um
 * @author Justin Siu-Ting Hui
 * @author Sheng Lor
 * 
 * @date December 16, 2017
 *
 */
public class TRLSystem {

	
	/*  Constructors */
	/**
	 *  TRLSystem
	 * 
	 * 	constructor
	 */
	public TRLSystem(){
		
	}
	
	/* Class Methods */

	/**
	 *	checkPatronID
	 *	Checks if the supplied Patron ID exists in the library.
	 * 
	 * @param 	patronID	The Patron ID to be checked. 
	 * @return				SUCCESS 		 	Patron ID exists in the library.
	 * 						PATRON_NOT_FOUND 	Patron ID does not exist in
	 * 											the library.
	 */
	public TRLReturnType checkPatronID(String patronID){
		if(TRLLibrary.getPatron(patronID) == null){
			return TRLReturnType.PATRON_NOT_FOUND;
		}
		else return TRLReturnType.SUCCESS;
	}

	/**
	 *	checkCopyID 
	 *	Checks if the supplied Copy ID exists in the library.
	 *
	 * @param copyID
	 * @return				SUCCESS 		 	Copy ID exists in the library.
	 * 						COPY_NOT_FOUND 		Copy ID does not exist in
	 * 											the library.
	 */
	public TRLReturnType checkCopyID(String copyID){
		if(TRLLibrary.getCopy(copyID) == null){
			return TRLReturnType.COPY_NOT_FOUND;
		}
		else return TRLReturnType.SUCCESS;
	}
	
	
	/**
	 * 	checkOut
	 * 	Performs a session checkout operation.
	 *
	 * 	@param	patronID	Patron ID string of the patron checking item out.
	 * 	@param	copyID		Copy ID string of item to be checked out. 
	 * 
	 * 	@return				true if successful, false if failed to check out
	 */
	public TRLReturnType checkOut(String patronID, String copyID){

		// Validate Inputs
		TRLReturnType returnValue;
		if( ((returnValue = checkPatronID(patronID)) != TRLReturnType.SUCCESS) ||
			((returnValue = checkCopyID(copyID)) != TRLReturnType.SUCCESS) ){
			return returnValue; 
		}
	
		// Perform Check Out Operation
		System.out.println("\nChecking out " + copyID + " to " + patronID + "...\n");
		if(TRLLibrary.checkOut(patronID, copyID)){
			System.out.println("Operation Complete.\n");
			return TRLReturnType.SUCCESS;
		}
		else {
			System.out.println("Check out failed");
			return TRLReturnType.UNKNOWN_ERROR;

		}
	}

	/**
	 *	canCheckOut
	 *	Checks whether or not a patron can perform a check out operation. This
	 *	determined by whether or not the patron has a hold on their account.
	 *
	 *  @param	patronID	Patron ID string of the patron to be checked.
	 *  @return				true if the patron has check out permission
	 *  					false if the patron is not allowed to perform a
	 *  					check out operation
	 */
	public boolean canCheckOut(String patronID){
		return !TRLLibrary.hasHold(patronID);
	}
	
	/**
	 * canCheckIn
	 * Checks whether or not a patron can perform a check in operation. This
	 * is determined by whether or not the patron currently has anything checked
	 * out. 
	 * 
	 * @param patronID	patron that is checked 
	 * @return			true if the patron can check in something, false if
	 * 					patron has no copies checked out
	 */
	public boolean canCheckIn(String patronID) {
		return TRLLibrary.hasCopy(patronID);
	}
	
	/**
	 *	getCopyInfo
	 *	Returns a description of the given library Copy.
	 *
	 *  @param	copyID		Patron ID string of the patron to be checked.
	 *  @return				Copy text description.
	 */
	public String getCopyInfo(String copyID){
		return TRLLibrary.getCopy(copyID).toString();
	}
	
	/**
	 *	getPatronInfo
	 *	Returns a description of the given library Copy.
	 *
	 *  @param	patronID	Patron ID string of the patron to be checked.
	 *  @return				Patron text description.
	 */
	public String getPatronInfo(String patronID){
		return TRLLibrary.getPatron(patronID).toString();
	}
	
	/**
	 * checkIn
	 * 
	 * Check in a copy that the patron currently has checked out.
	 * 
	 * @param patronID	the patron to check a copy in for.
	 * @param copyID	the copy to check in from the patron.
	 * @return
	 */
	public TRLReturnType checkIn(String patronID, String copyID){

		// Validate Inputs
		TRLReturnType returnValue;
		if( ((returnValue = checkPatronID(patronID)) != TRLReturnType.SUCCESS) ||
			((returnValue = checkCopyID(copyID)) != TRLReturnType.SUCCESS) ){
			return returnValue; 
		}
	
		// Perform Check In Operation
		System.out.println("\nChecking in " + copyID + " from " + patronID + "...\n");
		if(TRLLibrary.checkIn(patronID, copyID)){
			System.out.println("Operation Complete.\n");
			return TRLReturnType.SUCCESS;
		}
		else return TRLReturnType.UNKNOWN_ERROR;
	}
}