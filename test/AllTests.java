//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//public class AllTests {
//
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
//
//}

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	controller.ElevatorManagerTest.class,
	model.ElevatorTest.class,
	model.FloorTest.class,
	ui.SwingUserInterfaceTest.class
})

public class AllTests {

}
