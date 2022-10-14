package com.innoveller;

import com.innoveller.elevator.Elevator;
import com.innoveller.elevator.RequestListener;
import com.innoveller.elevator.RequestProcessor;

public class ElevatorMain {

	public static void main(String[] args) {
        System.out.println("Welcome to MyLift");
        
        // RequestListenerThread to read requested floor and add to Set
        Thread requestListenerThread = new Thread(new RequestListener(), "RequestListenerThread");
        
        // RequestProcessorThread to read Set and process requested floor
        Thread requestProcessorThread = new Thread(new RequestProcessor(), "RequestProcessorThread");
        
        Elevator.getInstance().setRequestProcessorThread(requestProcessorThread);        
        requestListenerThread.start();
        requestProcessorThread.start();       
    }
	
	
	public void test() {
		final int value = 10;
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(value);
			}
		};
	}
}
