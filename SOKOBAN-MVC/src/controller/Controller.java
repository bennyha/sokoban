package controller;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import controller.commands.Command;

public class Controller {

	private BlockingQueue<Command> myQueue = new ArrayBlockingQueue<Command>(1024);
	boolean isRun = true;
	
	public void start() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(isRun) {
					try {
						myQueue.take().execute();
					} 
					catch (Exception e) {
						e.printStackTrace();
					} 
				}
				System.out.println("controller's thread is close");
			}		
		}
	).start();
		
	}
	public void stop() { 
		this.isRun = false; 
	}
	
	public void insertCommand(Command command) {
			try {
				if (command != null)
					myQueue.put(command);
			} 
			catch (InterruptedException e) { 
				e.printStackTrace(); 
			}
		}
		
}
