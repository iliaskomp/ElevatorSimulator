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
import ui.SwingUI;
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

		ui = new SwingUI();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ui.setElevatorManager(uiManager);
				mainManager.setUI(ui);
				ui.show();

				TimerTask updateTask = new TimerTask() {
					@Override
					public void run() {
						mainManager.updateElevators();
					}
				};

				TimerTask uiUpdateTask = new TimerTask() {
					@Override
					public void run() {
						ui.update();
					}
				};

				Timer timer = new Timer("Update Timer");
				timer.schedule(updateTask, 50, UPDATE_INTERVAL);

				Timer uiTimer = new Timer("UI Update Timer");
				uiTimer.schedule(uiUpdateTask, 200, UPDATE_INTERVAL);
			}
		});

	}

}
