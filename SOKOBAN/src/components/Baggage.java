package components;

import java.awt.Point;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Baggage extends WorldObject implements Serializable {

	public Baggage() {}
	public Baggage(Point position) { super(position); }

	@Override
	public WorldObjectType getWorldObjectType() {
		return WorldObjectType.Baggage;
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
