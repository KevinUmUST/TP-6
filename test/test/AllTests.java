package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ttrl.CopyTest.class, ttrl.HoldTest.class, ttrl.PatronTest.class, ttrl.TRLLibraryTest.class, ttrl.TRLSessionTest.class,
		ttrl.TRLSystemTest.class, tgui.GUImenuTest.class, tgui.GUImainTest.class })
	public class AllTests {

}
