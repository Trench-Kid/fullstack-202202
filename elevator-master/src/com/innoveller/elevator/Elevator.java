package com.innoveller.elevator;

import java.util.TreeSet;

public class Elevator {
	private static Elevator elevator = null;

	private TreeSet<Integer> requestSet = new TreeSet<Integer>();
	private TreeSet<Integer> latterRequestSet = new TreeSet<Integer>();

	private int currentFloor = 0;

	private Direction direction = Direction.UP;

	private Direction userDir = null;

	public Direction getUserDir() {
		return userDir;
	}

	public void setUserDir(Direction userDir) {
		this.userDir = userDir;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Thread getRequestProcessorThread() {
		return requestProcessorThread;
	}

	public void setRequestProcessorThread(Thread requestProcessorThread) {
		this.requestProcessorThread = requestProcessorThread;
	}

	public TreeSet<Integer> getRequestSet() {
		return requestSet;
	}

	public void setRequestSet(TreeSet<Integer> requestSet) {
		this.requestSet = requestSet;
	}

	private Elevator() {
	};

	private Thread requestProcessorThread;

//	 singleton instance

	public static Elevator getInstance() {
		if (elevator == null) {
			elevator = new Elevator();
		}
		return elevator;
	}

	public synchronized void addFloor(int f) {

		System.out.println("user dir: "+elevator.getUserDir());
		System.out.println("ele dir: "+elevator.getDirection());

		if (elevator.getUserDir() == elevator.getDirection() 
				|| elevator.getUserDir() == null
				|| elevator.getDirection() == null
				|| ((elevator.getCurrentFloor() > f) && (elevator.getDirection() == Direction.UP) 
				&& (elevator.getUserDir()==null))
				|| ((elevator.getCurrentFloor() < f) && (elevator.getDirection() == Direction.DOWN)
				&& (elevator.getUserDir()==null))) {
			requestSet.add(f);

			if (requestProcessorThread.getState() == Thread.State.WAITING) {
				// Notify processor thread that a new request has come if it is waiting
				notify();
			} else {
				// Interrupt Processor thread to check if new request should be processed before
				// current request or not.
				requestProcessorThread.interrupt();
			}
		} else if (elevator.getUserDir() != elevator.getDirection()) {
			latterRequestSet.add(f);
		}
	}

//	  next request to process based on elevator current floor and direction

	public synchronized int nextFloor() {

		Integer floor = null;
		if (direction == Direction.UP) {
			if (requestSet.ceiling(currentFloor) != null) {
				floor = (Integer) requestSet.ceiling(currentFloor);
			} else {
				floor = (Integer) requestSet.floor(currentFloor);
			}
		} else {
			if (requestSet.floor(currentFloor) != null) {
				floor = (Integer) requestSet.floor(currentFloor);
			} else {
				floor = (Integer) requestSet.ceiling(currentFloor);
			}
		}
		if (floor == null && !latterRequestSet.isEmpty()) {
			// changed here!
			if (latterRequestSet.ceiling(currentFloor) != null) {
				floor = (Integer) latterRequestSet.ceiling(currentFloor);
				latterRequestSet.remove(floor);
			} else {
				floor = (Integer) latterRequestSet.floor(currentFloor);
				latterRequestSet.remove(floor);
			}
		}

		if (floor == null) {

			try {
				System.out.println("Waiting at Floor :" + getCurrentFloor());
				setDirection(null);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			// Remove the request from Set when the request is in Progress.
			requestSet.remove(floor);
		}
		return (floor == null) ? -1 : floor;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	// Set current floor and direction based on requested floor

	public void setCurrentFloor(int currentFloor) throws InterruptedException {
		if (this.currentFloor > currentFloor) {
			setDirection(Direction.DOWN);
		} else {
			setDirection(Direction.UP);
		}
		this.currentFloor = currentFloor;

		System.out.println("Floor : " + currentFloor);

		Thread.sleep(1000);
	}

}
