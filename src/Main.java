import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import controller.ElevatorManager;
import model.Elevator;
import sqelevator.IElevator;

public class Main {

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		
		IElevator controller = (IElevator) Naming.lookup("rmi://localhost/ElevatorSim");

		ElevatorManager manager = new ElevatorManager();
		
		
//		Elevator e = new Elevator(controller.getElevatorPosition(0), 
//									controller.getElevatorSpeed(0), 
//									controller.getElevatorCapacity(0), 
//									controller.getElevatorDoorStatus(0));
		
		Elevator e = new Elevator(controller.getFloorNum());
		manager.addElevator(e);
	}

}
