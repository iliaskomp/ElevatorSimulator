package start;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Timer;
import java.util.TimerTask;

import controller.ElevatorManager;
import sqelevator.IElevator;
import test.DummyElevator;
import ui.SwingUserInterface;
import ui.UserInterface;

public class Main {
	private static UserInterface ui;
	//update interval in miliseconds
	private static final long UPDATE_INTERVAL = 1000;

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		IElevator controller = new DummyElevator();
		ui = new SwingUserInterface();
		ElevatorManager manager = new ElevatorManager(controller);

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ui.show();
				manager.setUi(ui);
			}
		});

		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
					manager.updateElevators();
			}
		};

		Timer timer = new Timer("Update Timer");
		timer.schedule(timerTask, 50, UPDATE_INTERVAL);
	}

}
