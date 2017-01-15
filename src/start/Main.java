package start;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Timer;
import java.util.TimerTask;

import controller.ElevatorManager;
import controller.ElevatorManagerInterface;
import sqelevator.IElevator;
import test.DummyElevator;
import ui.SwingUserInterface;
import ui.UIInterface;

public class Main {
	private static UIInterface ui;
	//update interval in miliseconds
	private static final long UPDATE_INTERVAL = 1000;

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		IElevator controller = new DummyElevator();
		ElevatorManagerInterface manager = new ElevatorManager(controller);
		manager.updateElevators();

		ui = new SwingUserInterface();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ui.setElevatorManager(manager);
				ui.show();

				TimerTask timerTask = new TimerTask() {
					@Override
					public void run() {
							manager.updateElevators();
							ui.update();
					}
				};

				Timer timer = new Timer("Update Timer");
				timer.schedule(timerTask, 50, UPDATE_INTERVAL);
			}
		});

	}

}
