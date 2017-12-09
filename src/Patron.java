
/**
 * 
 * Starting class for TP-1
 * 
 * Feel free to add, modify, or delete any of the following code: it's just a
 * possible starting implementation
 *
 * @author eric
 *
 */

import java.util.ArrayList;

public class Patron
{
	private String name;
	private String patronID;
	private ArrayList<Copy> copiesOut;
	private ArrayList<Hold> holds;
	
	public Patron(String id, String name)
	{
		this.patronID = id;
		this.name = name;
		this.copiesOut = new ArrayList<Copy>();
		this.holds = new ArrayList<Hold>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronID() {
		return patronID;
	}

	public void setPatronID(String patronID) {
		this.patronID = patronID;
	}

	public ArrayList<Copy> getCopiesOut() {
		return copiesOut;
	}

	public void setCopiesOut(ArrayList<Copy> copiesOut) {
		this.copiesOut = copiesOut;
	}
	
	public Integer numCheckedOutCopies() {
		return copiesOut.size();
	}
		
	
	public Integer numHolds(){
		return holds.size();
	}

	public boolean checkCopyOut(Copy c)
	{
		if (!c.checkedOut())
		{
			//c.setOutTo(this);  I don't think this code is necessary because the same code is in TRLLibrary's checkOut method. And the app seems to run fine.
			copiesOut.add(c);
			return true;
		}
		else return false;
	}

	public boolean checkCopyIn(Copy c)
	{

		if(c.getOutTo()==null)
		{
			return false;
		}
		
		else if(c.getOutTo().equals(this))
		{
			//c.setOutTo(null);   same reason, I don't think this code is necessary because the same code is in TRLLibrary's checkIn method. And the app seems to run fine.
			copiesOut.remove(c);
			return true;
		}

		else return false;
	}
	
	public boolean addHold(Hold h){
		holds.add(h);
		return true;
	}
	
	public boolean removeHold(Hold h){
		holds.remove(h);
		return true;
	}

	@Override
	public boolean equals(Object o)
	{
		return ((o instanceof Patron) && (((Patron) o).getPatronID() == this.patronID));
	}

	public String toString()
	{
		return "Patron ID: " + this.patronID + "\nName: " + this.name + 
				   "\nBooks Borrowing: " + copiesOut.toString() + 
				   "\nHolds: " + holds.toString() + "\n";
	}

}
