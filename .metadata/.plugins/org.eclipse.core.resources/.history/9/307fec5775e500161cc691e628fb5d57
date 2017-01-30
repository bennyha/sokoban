package component;

import java.awt.Point;
import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Component implements Serializable {

	protected Point position;
	protected boolean onTarget = false;
	
	public Component() {}
	
	public Component(Point position) { 
		this.position = position; 
	}
		
	public abstract boolean onTarget();
	
	public abstract char getObjRep();
	
	public abstract ComponentType getComponentType();

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public boolean getOnTarget() {
		return onTarget;
	}

	public void setOnTarget(boolean onTarget) {
		this.onTarget = onTarget;
	}

	

	
}