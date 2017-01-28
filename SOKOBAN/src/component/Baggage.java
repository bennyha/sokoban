package component;

import java.awt.Point;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Baggage extends Component implements Serializable {

	public Baggage() {}
	public Baggage(Point position) { 
		super(position); 
	}

	@Override
	public ComponentType getComponentType() {
		return ComponentType.Baggage;
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
