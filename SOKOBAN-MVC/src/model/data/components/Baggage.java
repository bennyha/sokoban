package model.data.components;

import java.awt.Point;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Baggage extends Components implements Serializable {

	public Baggage() {}
	public Baggage(Point position) { super(position); }

	@Override
	public ComponentsType getComponentType() {
		return ComponentsType.BAGGAGE;
	}

	@Override
	public char getObjRep() {
		return '@';
	}

	@Override
	public boolean onTarget() {
		return onTarget;
	}
	
}
