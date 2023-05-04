package se.kth.iv1350.saleprocess.startup;

import se.kth.iv1350.saleprocess.controller.Controller;
import se.kth.iv1350.saleprocess.view.View;
import se.kth.iv1350.saleprocess.integration.RegistryCreator;
import se.kth.iv1350.saleprocess.integration.Printer;

/**
 * Starts the application. 
 */
public class Main {
	
	/**
	 * Main method used to start the application.
	 * 
	 * @param args The application does not take any command line parameters.
	 */
	public static void main(String[] args) {
		RegistryCreator creator = new RegistryCreator();
		Printer printer = new Printer();
		Controller controller = new Controller(creator, printer);
		View view = new View(controller);
		view.runFakeExecution();
	}
}
