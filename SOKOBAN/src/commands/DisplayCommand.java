package commands;

import level.Level;
import receiver.display.DisplayLevel;

public class DisplayCommand implements Command {

	DisplayLevel displayer = null;
	
	public DisplayCommand(Level level) { displayer = new DisplayLevel(level); }
	
	@Override
	public void execute() {
		displayer.display();
	}

}