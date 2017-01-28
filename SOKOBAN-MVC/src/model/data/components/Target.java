package model.data.components;

import java.awt.Point;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Target extends Components implements Serializable{

	public Target() {}
	public Target(Point position) {	super(position); }

	@Override
	public ComponentsType getComponentType() {
		return ComponentsType.TARGET;
	}

	@Override
	public char getObjRep() {
		return 'o';
	}

	@Override
	public boolean onTarget() {
		return false; // target can't be on target
	}

}
