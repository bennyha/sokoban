package command;

import level.Level;
import receiver_display.DisplayLevel;

public class DisplayCommand implements Command {

	DisplayLevel displayer = null;
	
	public DisplayCommand(Level level) { 
		displayer = new DisplayLevel(level); 
	}
	
	@Override
	public void execute() {
		displayer.display();
	}

}