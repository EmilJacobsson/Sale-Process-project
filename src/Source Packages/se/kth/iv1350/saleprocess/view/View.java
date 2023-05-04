package se.kth.iv1350.saleprocess.view;

import se.kth.iv1350.saleprocess.controller.Controller;
import se.kth.iv1350.saleprocess.model.ItemSaleInfoDTO;
import java.util.List;
import java.util.ArrayList;

/**
 * This is a placeholder for the real view. It contains a hard-coded execution with calls to all
 * system operations in the controller.
 */

public class View {
	private Controller controller;
	
	/**
	 * Creates a new instance that uses the specified controller for all calls to other layers. 
	 * 
	 * @param controller The controller to use for all calls to other layers. 
	 */
	public View(Controller controller) {
		this.controller = controller;
	}
	
	/**
	 * Performs a fake sale by calling all system operations in the controller. 
	 */
	public void runFakeExecution() {
		controller.startSale();
		System.out.println("A new sale has been started.");
		
		List<ItemSaleInfoDTO> collectedItemSaleInfo = new ArrayList<ItemSaleInfoDTO>();
		ItemSaleInfoDTO itemSaleInfo = controller.registerItem(4, 3);
		collectedItemSaleInfo.add(itemSaleInfo);
		
		itemSaleInfo = controller.registerItem(1, 5);
		collectedItemSaleInfo.add(itemSaleInfo);
		
		itemSaleInfo = controller.registerItem(6, 2);
		collectedItemSaleInfo.add(itemSaleInfo);
		
		itemSaleInfo = controller.registerItem(3, 1);
		collectedItemSaleInfo.add(itemSaleInfo);
		
		itemSaleInfo = controller.registerItem(2, 1);
		collectedItemSaleInfo.add(itemSaleInfo);
		
		itemSaleInfo = controller.registerItem(5, 3);
		collectedItemSaleInfo.add(itemSaleInfo);
		
		itemSaleInfo = controller.registerItem(1, 1);
		collectedItemSaleInfo.add(itemSaleInfo);
		
		itemSaleInfo = controller.registerItem(2, 5);
		collectedItemSaleInfo.add(itemSaleInfo);
		
		for (ItemSaleInfoDTO itemSaleInfoToPrint : collectedItemSaleInfo) {
			System.out.println("\nNew item(s) added to the sale.\nTotal price: " 
		                       + itemSaleInfoToPrint.getTotalPrice() + "\nDescription: " 
					           + itemSaleInfoToPrint.getDescription() + "\nPrice: " 
		                       + itemSaleInfoToPrint.getPrice());
		}
		
		int totalPrice = controller.signalEndSale();
		System.out.println("\nTo pay: " + totalPrice + "\n");
		int paidAmount = 1200;
		int change = controller.pay(paidAmount);
		System.out.print("\nChange: " + change);
	}
}
