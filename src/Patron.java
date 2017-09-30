
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

	public Patron(String id, String name)
	{
		// finish this
	}

	public boolean checkCopyOut(Copy c)
	{
		// finish this

		return false;
	}

	public boolean checkCopyIn(Copy c)
	{
		// finish this
		return false;
	}

	@Override
	public boolean equals(Object o)
	{
		// finish this: two are equals iff same patron ID

		return false;
	}

	public String toString()
	{
		// finish this: return basic Patron info as String

		return "A description of this Patron's current state.";
	}

	// put test code in your main(), but realize it's not unit testing!

	public static void main(String[] args)
	{
		Patron p1 = new Patron("P47", "Eric");

		System.out.println(p1);

		Patron p2 = FakeDB.getPatron("P47");
		Copy c1 = FakeDB.getCopy("C1");
	}

}
