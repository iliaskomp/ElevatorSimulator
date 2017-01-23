package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	controller.ElevatorManagerTest.class,
	controller.ElevatorAlgorithmTest.class,
	model.ElevatorTest.class,
	model.FloorTest.class,
	ui.SwingUserInterfaceTest.class
})

public class AllTests {

}
