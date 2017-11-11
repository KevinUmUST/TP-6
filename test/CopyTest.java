import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CopyTest {

	// Class Under Test
	Copy CUT;
	Patron p;
	
	private final String copyID = "TEST_COPY_ID";
	private final String copyTitle = "TEST_COPY_TITLE";
	private final String patronID = "TEST_PATRON_ID";
	private final String patronName = "PATRON NAME";
	
	@Before
	public void setUp() throws Exception {
		CUT = new Copy(copyID, copyTitle);
		p = new Patron(patronID, patronName);
	}

	@Test
	public void constructor_test() {
		// CUT instantiated in setUp()
		assert(CUT != null);
		assertEquals(CUT.getCopyID(), copyID);
		assertEquals(CUT.getTitle(), copyTitle);
	}
	
	@Test
	public void getset_test(){
		
		// Set Copy ID
		String newCopyID = copyID + "*";
		CUT.setCopyID(newCopyID);
		assertEquals(CUT.getCopyID(), newCopyID);
		CUT.setCopyID(copyID);
		
		// Set Out To Patron
		CUT.setOutTo(p);
		assert(CUT.getOutTo().equals(p));
		CUT.setOutTo(null);
		
		// Set Copy Title
		String newTitle = copyTitle + "*";
		CUT.setTitle(newTitle);
		assertEquals(CUT.getTitle(), newTitle);
	}

	@Test
	public void checkedOut_test(){
		assert(!CUT.checkedOut());
		CUT.setOutTo(p);
		assert(CUT.checkedOut());
		CUT.setOutTo(null);
	}
	
	@Test
	public void equals_test(){
		// Same Copy ID but Different Title
		Copy copyCopy = new Copy(copyID, "Different Title");
		assert(CUT.equals(copyCopy));
	
		// Same Copy ID and Same Copy Title
		copyCopy = new Copy(copyID, copyTitle);
		assert(CUT.equals(copyCopy));
	
		// Different Copy ID Same Copy Title
		copyCopy = new Copy("Different Copy ID", copyTitle);
		assert(!CUT.equals(copyCopy));
		
		// Different Copy ID Different Copy Title
		copyCopy = new Copy("Different Copy ID", "Different Title");
		assert(!CUT.equals(copyCopy));
		
		// Not an instance of Copy
		assert(!CUT.equals(p));
	}

}
