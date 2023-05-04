package se.kth.iv1350.saleprocess.integration;

import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.saleprocess.model.Sale;
import org.junit.jupiter.api.Test;

class InventoryRegistryTest {

	@Test
	public void testGetItemInfoQuantityEqual() {
		int identifier = 4;
		int soldQuantity = 3;
		int price = 40;
		double vat = 1.06;
		String description = "Canned Tomatoes";
		ItemDTO searchedItem = new ItemDTO (identifier, soldQuantity, price, vat, description);
		
		InventoryRegistry instance = new InventoryRegistry();
	    ItemDTO expResult = searchedItem;
	    ItemDTO result = instance.getItemInfo(identifier, soldQuantity);
	    assertEquals(expResult, result, "Equal items not equal");
	}
	
	@Test
	public void testGetItemInfoQuantityNotEqual() {
		int identifier = 4;
		int soldQuantity = 3;
		int price = 40;
		double vat = 1.06;
		String description = "Canned Tomatoes";
		ItemDTO searchedItem = new ItemDTO (identifier, soldQuantity, price, vat, description);
		
		int otherSoldQuantity = 5;
		InventoryRegistry instance = new InventoryRegistry();
	    ItemDTO expResult = searchedItem;
	    ItemDTO result = instance.getItemInfo(identifier, otherSoldQuantity);
	    assertEquals(expResult, result, "Equal items not equal");
	}
	
	@Test
	public void testUpdateInventoryCorrectItemQuantity() {
		InventoryRegistry instance = new InventoryRegistry();
		int identifier = 4;
		int soldQuantity = 3;
		int price = 40;
		double vat = 1.06;
		String description = "Canned Tomatoes";
		ItemDTO searchedItem = new ItemDTO (identifier, soldQuantity, price, vat, description);
		
		Sale sale = new Sale();
		sale.addItemToSale(searchedItem);
		int paidAmount = 150;
		SaleInfoDTO saleInfo = sale.endSale(paidAmount);
		instance.updateInventory(saleInfo);
		int inventoryQuantity = 20;
		int expResult = inventoryQuantity - soldQuantity;
		int result = instance.getQuantity(identifier);
		assertEquals(expResult, result, "Wrong item quantity in inventory");
	}
}
