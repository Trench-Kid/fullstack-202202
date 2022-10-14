package com.innoveller.elevator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RequestListener implements Runnable {

	@Override
	public void run() {

		while (true) {
			String floorNumberStr = null;
			try {
				// Read input from console
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				floorNumberStr = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("User Pressed : " + floorNumberStr);

			String[] floorInput = floorNumberStr.split(" ");
			
			Elevator elevator = Elevator.getInstance();
			if (floorInput.length == 2) {
				if (floorInput[1].equalsIgnoreCase("u")) {
					elevator.setUserDir(Direction.UP);
				} else if (floorInput[1].equalsIgnoreCase("d")) {
					elevator.setUserDir(Direction.DOWN);
				}
			} else {
				if (Integer.parseInt(floorInput[0]) < elevator.getCurrentFloor()
						&& elevator.getDirection() == Direction.DOWN) {
					elevator.setUserDir(Direction.DOWN);
//					elevator.addFloor(Integer.parseInt(floorInput[0]));
				} else if (Integer.parseInt(floorInput[0]) > elevator.getCurrentFloor()
						&& elevator.getDirection() == Direction.UP) {
					elevator.setUserDir(Direction.UP);
//					elevator.addFloor(Integer.parseInt(floorInput[0]));
				}
			}
			elevator.addFloor(Integer.parseInt(floorInput[0]));
		}
	}

}
