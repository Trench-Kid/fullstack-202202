package com.trenchkid.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trenchkid.application.data.Product;

public class VendingMachine implements VendingMachineService {

	private int remainingAmount = 0;
	int productId;
	int givenQuantity;
	int value;

	private List<Product> list = new ArrayList<>();
	private Scanner scan = new Scanner(System.in);
	private int menuId;

	@Override
	public void showMenu() {

		System.out.println();
		System.out.println("1.Save money");
		System.out.println("2.Shopping");
		System.out.println("3.Show remaining balance");
		System.out.println("--------------------------------");

	}

	@Override
	public void selectOperationsFromMenu() {

		do { // Validate Integer and Negative value of the input.
			System.out.println("You can select only 1 to 3.");
			System.out.print("Select Menu ID -> ");
			while (!scan.hasNextInt()) {
				System.out.println("Incorrect input. Try again!");
				scan.next();
			}
			menuId = scan.nextInt();
		} while (menuId <= 0);

		switch (menuId) {
		case 1:
			saveMoney();
			break;
		case 2:
			showProducts();
			break;
		case 3:
			showRemainingBalance();

		default:
			selectOperationsFromMenu();

			break;

		}

	}

	@Override
	public void saveMoney() {

		do { // Validate Integer and Negative value of the input.
			System.out.println("Enter amount to save.");
			while (!scan.hasNextInt()) {
				System.out.println("Incorrect input. Try again!");
				scan.next();
			}
			value= scan.nextInt(); // Set money amount.
		} while (value <= 0);
		remainingAmount += value;
		System.out.println(String.format("Amount: %d", getRemainingAmount()));

	}

	@Override
	public void showProducts() {

		// add some products to the list
		if (list.isEmpty() || list == null) {
			list.add(new Product(1, "Cola", 500, 10));
			list.add(new Product(2, "Nes cafe", 500, 10));
			list.add(new Product(3, "Potato Chip", 700, 10));
			list.add(new Product(4, "Fish Chip", 1000, 10));
		}

		list.stream().forEach(product -> {
			System.out.println(String.format("%d.%s -> %d Ks / %d instock", product.getId(), product.getName(),
					product.getPrice(), product.getQuantity()));
		});
		doShopping();

	}

	@Override
	public void showRemainingBalance() {
		System.out.printf("Your balance: %d", getRemainingAmount());
		System.out.println();

	}

	public int getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(int remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	@Override
	public void calculateTotalPrice(Product product, int givenQuantity) {
		// Find total amount
		int totalCost = product.getPrice() * givenQuantity;
		// Checks quantity
		if (givenQuantity > product.getQuantity()) {
			System.out.println(String.format("Sorry! We have only %d items in our storage", product.getQuantity()));
			// Checks money
		} else if (totalCost > remainingAmount) {
			System.out.println("Not enough money.");
		} else {
			product.setQuantity(product.getQuantity() - givenQuantity);
			remainingAmount = remainingAmount - (totalCost);
			System.out.println("Remaining Balance: " + remainingAmount);
			System.out.println(String.format("Expense: %d", totalCost));
		}

	}

	public void doShopping() {

		do { // Validate Integer and Negative value of the input.

			System.out.println("Select product number.");

			while (!scan.hasNextInt()) {
				System.out.println("Incorrect input. Try again!");
				scan.next();
			}
			productId = scan.nextInt(); // Set money amount.
		} while (productId <= 0 || productId > list.size());

		do { // Validate Integer and Negative value of the input.

			System.out.println("How many do you need?");

			while (!scan.hasNextInt()) {
				System.out.println("Incorrect input. Try again!");
				scan.next();
			}
			givenQuantity = scan.nextInt(); // Set money amount.
		} while (givenQuantity <= 0);

		// Calculate total amount
		calculateTotalPrice(list.get(productId - 1), givenQuantity);
	}

}
