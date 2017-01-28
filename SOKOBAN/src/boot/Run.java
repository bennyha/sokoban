package boot;

import java.io.IOException;

import view.CLI;

public class Run {
	
	public static void main(String args[]) {
	
		CLI cli = new CLI();
		
		while (!cli.isExit()) {
			try 
			{
				cli.run();	
			} 
			catch (IOException e) {
				e.printStackTrace();
				}
		}
	}
}
	