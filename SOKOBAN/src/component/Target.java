package component;

import java.awt.Point;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Target extends Component implements Serializable{

	public Target() {}
	public Target(Point position) {	
		super(position); 
	}

	@Override
	public ComponentType getComponentType() {
		return ComponentType.TARGET;
	}

	@Override
	public char getObjRep() {
		return 'o';
	}

	@Override
	public boolean onTarget() {
		return false;
	}

}