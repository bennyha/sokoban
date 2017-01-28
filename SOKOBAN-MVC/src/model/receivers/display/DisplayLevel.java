package model.receivers.display;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.data.components.Components;
import model.data.level.Level;

public class DisplayLevel {
	
	Level level;
	//OutputStream out;
	
	public DisplayLevel(Level level, OutputStream out) {
		this.level = level;
		}
	
	public void display(OutputStream out) {
		
		PrintWriter writer = new PrintWriter(out);
		for (ArrayList<Components> a : level.getGrid())
		{
			for (Components w : a)
				writer.print(w.getObjRep());
			writer.println();
			writer.flush();
		}
	}

}
