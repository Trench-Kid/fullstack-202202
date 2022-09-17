package com.trenchkid.application.service;

import com.trenchkid.application.data.Product;

public interface VendingMachineService {
	
	// Show menu.
	void showMenu();
	
	// Select Operations from menu.
	void selectOperationsFromMenu();
	
	// Do Save Money
	void saveMoney();
	
	// Do Show Products
	void showProducts();
	
	// Do Show Remaining Balance
	void showRemainingBalance();
	
	void calculateTotalPrice(Product product, int givenQuantity);

}
