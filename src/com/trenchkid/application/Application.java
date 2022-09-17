package com.trenchkid.application;

import java.util.Scanner;

import com.trenchkid.application.service.VendingMachine;

public class Application {
	
	private static final String QUIT = "Do you want to quit? (Y to quit/other keys to continue)";
	
	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine();
		
		// Print Welcome Title
		System.out.println("===================");
		System.out.println("======Welcome======");
		System.out.println("===================");
		
		// Show Menu
		vm.showMenu();
		
		// Ask to select Options from menu.
		vm.selectOperationsFromMenu();
		
		Scanner sc = new Scanner(System.in);
		// Ask to quit
		System.out.println(QUIT);
		
		
		while(!sc.nextLine().equalsIgnoreCase("y")) {
			vm.showMenu(); // Quit or Show Menu Again
			vm.selectOperationsFromMenu();
			
			System.out.println(QUIT);
		}
		
		System.out.println("Good Bye");
		sc.close();
		
	}

}
