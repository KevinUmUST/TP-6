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

public class TRLSystem {

	
	/*  Constructors */
	TRLSystem(){
		
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
		else return TRLReturnType.UNKNOWN_ERROR;
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
}
