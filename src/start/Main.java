package start;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Timer;
import java.util.TimerTask;

import controller.ElevatorManager;
import controller.ElevatorManagerInterface;
import controller.ElevatorManagerMainInterface;
import controller.ElevatorManagerUIInterface;
import sqelevator.IElevator;
import test.DummyElevatorSimulator;
import ui.SwingUserInterface;
import ui.UIInterface;

public class Main {
	private static UIInterface ui;
	// update interval in miliseconds
	private static final long UPDATE_INTERVAL = 100;

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		// IElevator controller = (IElevator) Naming.lookup("rmi://localhost/ElevatorSim");
		IElevator controller = new DummyElevatorSimulator();
		ElevatorManager manager = new ElevatorManager(controller);
		ElevatorManagerMainInterface mainManager = manager;
		ElevatorManagerUIInterface uiManager = manager;
		manager.updateElevators();

		ui = new SwingUserInterface();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ui.setElevatorManager(uiManager);
				mainManager.setUI(ui);
				ui.show();

				TimerTask timerTask = new TimerTask() {
					@Override
					public void run() {
						mainManager.updateElevators();
						ui.update();
					}
				};

				Timer timer = new Timer("Update Timer");
				timer.schedule(timerTask, 50, UPDATE_INTERVAL);
			}
		});

	}

}
