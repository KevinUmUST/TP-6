import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HoldTest {
	
	private final String copyID = "TEST_COPY_ID";
	private final String copyTitle = "TEST_COPY_TITLE";
	
	// Class Under Test
	Hold CUT;
	Copy c;
	
	@Before
	public void setUp() throws Exception {
		c = new Copy(copyID, copyTitle);
		CUT = new Hold(c);
	}

	@Test
	public void constructor_test() {
		// CUT instantiated in setUp()
		assert(CUT.getCopy().equals(c));
	}

}
