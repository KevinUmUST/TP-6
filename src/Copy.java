/**
 * 	Copy
 * 
 * 	Describes a copy of a library item.
 * 
 *	@author
 */
public class Copy
{
	private String copyID;
	private String title;
	private Patron outTo;

	public Copy(String copyID, String title)
	{
		this.copyID = copyID;
		this.title = title;
		this.outTo = null;
	}

	public String getCopyID() {
		return copyID;
	}

	public void setCopyID(String copyID) {
		this.copyID = copyID;
	}

	public Patron getOutTo() {
		return outTo;
	}

	public void setOutTo(Patron outTo) {
		this.outTo = outTo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String toString()
	{
		String patron = (outTo == null) ? "(Not Checked Out)" : this.outTo.getName();
		return "Copy ID: " + this.copyID + "\nTitle: " + this.title + 
			   "\nChecked Out To: " + patron + "\n";
	}
	
	public boolean checkedOut()
	{
		return outTo != null;
	}

	@Override
	public boolean equals(Object o)
	{
		return ((o instanceof Copy) && (((Copy) o).getCopyID() == this.copyID));
	}

	public static void main(String[] args)
	{
		Copy c1 = new Copy("C1", "Fun with Objects");
		Patron p1 = new Patron("Eric", "P47");

		System.out.println(c1);
		System.out.println(p1);

		Copy c2 = FakeDB.getCopy("C2");
	}
}
