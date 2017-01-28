package receiver_display;

import java.util.ArrayList;

import level.Level;
import component.Component;;

public class DisplayLevel {
	
	Level level = null;
	
	public DisplayLevel(Level level) {
		this.level = level;
	}
	
	public void display() {
		
		for (ArrayList<Component> a : level.getLevel())
		{
			for (Component w : a)
				System.out.print(w.getObjRep());
			System.out.println();
		}
	}

}