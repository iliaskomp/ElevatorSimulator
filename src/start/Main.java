package start;

import ui.SwingUserInterface;
import ui.UserInterface;

public class Main {
	static UserInterface ui;

	public static void main(String[] args) {
		 ui = new SwingUserInterface();
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                ui.show();
	            }
	        });
	}

}
