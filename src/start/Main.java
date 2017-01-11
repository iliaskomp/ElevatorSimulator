package start;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.sun.javafx.tk.DummyToolkit;

import controller.ElevatorManager;
import model.Elevator;
import sqelevator.IElevator;
import test.DummyElevator;
import ui.SwingUserInterface;
import ui.UserInterface;

public class Main {
	static SwingUserInterface ui;

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		IElevator controller = new DummyElevator();
		
		 ui = new SwingUserInterface();
//		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
//	            public void run() {
//	                ui.show();
//	            }
//	        });
		 ui.show();
		 ElevatorManager manager = new ElevatorManager(controller);
		 manager.setUi(ui);
		 
		 
	}

}
