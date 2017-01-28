package controller.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Observable;

public class CLI extends Observable implements ClientHandler {

	private String userInput;
	OutputStream out;
	boolean run = true;

	@Override
	public void handleClient(InputStream clientInput, OutputStream clientOutput) {
	
		this.out = clientOutput;
		PrintWriter writer = new PrintWriter(clientOutput);
		BufferedReader reader = new BufferedReader(new InputStreamReader(clientInput));

		System.out.println("This is the Sokoban game!");
		System.out.println("Please choose command:"+"\n"
							+"Load filename"+"\n"
							+"Display"+"\n"
							+"Move {up, down, left, right}"+"\n"
							+"Save 'filepath'"+" ending"+"\n"
							+"Exit"+"\n"+"\n");
		
		writer.flush();
		run = true;
		try {
		while(run) {
			
					userInput = reader.readLine();
					userInput = userInput.toLowerCase();
					System.out.println(userInput);
					if (userInput.equals("exit")) {
						run = false;
						writer.println("GoodBye");
					    writer.flush();
					}
					setChanged();
					notifyObservers(userInput);
			
			} 
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}

	@Override
	public OutputStream getOutputStream() {
		return out;
	}

}
