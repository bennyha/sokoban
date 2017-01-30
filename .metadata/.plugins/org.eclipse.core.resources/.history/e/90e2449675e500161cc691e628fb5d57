package component;

import java.awt.Point;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Floor extends Component implements Serializable {

	public Floor() {}
	public Floor(Point position) { 
		super(position); 
	}

	@Override
	public ComponentType getComponentType() {
		return ComponentType.FLOOR;
	}

	@Override
	public char getObjRep() {
		return ' ';
	}

	@Override
	public boolean onTarget() {
		return false; 
	}
 
	
}