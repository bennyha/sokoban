package model.data.component;

import java.awt.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Component implements Serializable {

	protected static Point position;
	protected static boolean onTarget = false;
	
	public Component() {}
	
	public Component(Point position) { 
		this.position = position; 
		}
		
	public abstract boolean onTarget();
	
	public abstract char getObjRep();
	
	public abstract ComponentType getComponentType();

	public static Point getPosition() {
		return position;
		}

	public void setPosition(Point position) {
		this.position = position;
		}

	public static boolean getOnTarget() {
		return onTarget;
		}

	public void setOnTarget(boolean onTarget) {
		this.onTarget = onTarget;
		}

	

	
}
