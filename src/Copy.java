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
public class Copy
{
	private String copyID;
	private String title;
	private Patron outTo;

	public Copy(String copyID, String title)
	{
		// finish this
	}

	// generate getters and setters using Eclipse Source menu

	public String toString()
	{
		// correctly implement this
		return "A description of this Copy's current state.";
	}

	@Override
	public boolean equals(Object o)
	{
		// finish this: two are equals iff same copy ID

		return false;
	}

	// put test code in your main(), but realize it's not unit testing!

	public static void main(String[] args)
	{
		Copy c1 = new Copy("C1", "Fun with Objects");
		Patron p1 = new Patron("Eric", "P47");

		System.out.println(c1);
		System.out.println(p1);

		Copy c2 = FakeDB.getCopy("C2");
	}
}
