package start;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import controller.ElevatorManager;
import model.Elevator;
import sqelevator.IElevator;
import ui.SwingUserInterface;
import ui.UserInterface;

public class Main {
	static UserInterface ui;

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		IElevator controller = (IElevator) Naming.lookup("rmi://localhost/ElevatorSim");
		ElevatorManager manager = new ElevatorManager(controller);
     
		Elevator e = new Elevator(0);
		
		//manager.addElevator(e);
		
		 ui = new SwingUserInterface();
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                ui.show();
	            }
	        });
		 
		 manager.setUi(ui);
	}

}
