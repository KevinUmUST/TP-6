import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CopyTest.class, HoldTest.class, PatronTest.class, TRLLibraryTest.class, TRLSessionTest.class,
		TRLSystemTest.class })
	public class AllTests {

}
