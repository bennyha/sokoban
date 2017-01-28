package model.data.components;

import java.awt.Point;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Floor extends Components implements Serializable {

	public Floor() {}
	public Floor(Point position) { super(position); }

	@Override
	public ComponentsType getComponentType() {
		return ComponentsType.FLOOR;
	}

	@Override
	public char getObjRep() {
		return ' ';
	}

	@Override
	public boolean onTarget() {
		return false; // floor can't be on target
	}
 
	
}
