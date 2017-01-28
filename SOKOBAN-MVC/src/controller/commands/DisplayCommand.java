package controller.commands;

import java.io.OutputStream;

import controller.server.MyServer;
import model.Model;
import model.receivers.display.DisplayLevel;

public class DisplayCommand implements Command {

	
	DisplayLevel display;
	//OutputStream out; 
	Model model;
	MyServer myServer;
	
//	public void setLevelToDisplay(Model model) { displayer = new DisplayLevel(model.getLevel(),out); }
	
	public DisplayCommand(Model model, MyServer myServer) { 
		this.model = model;
		this.myServer = myServer;
	}

	@Override
	public void execute() {
		OutputStream out = myServer.getCH().getOutputStream();
		display = new DisplayLevel(model.getLevel(),out);
		display.display(out);
	}

	@Override
	public void setDefinitions(String[] params) {}

}
