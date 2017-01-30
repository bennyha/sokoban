package model.data.component;

import java.awt.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Floor extends Component implements Serializable {

	public Floor() {}
	public Floor(Point position) { super(position); }


	@Override
	public char getObjRep() {return ' ';}

	@Override
	public boolean onTarget() {return false;} // floor can't be on target
	@Override
	public ComponentType getComponentType() {
		return ComponentType.FLOOR;

	}
 
	
}
