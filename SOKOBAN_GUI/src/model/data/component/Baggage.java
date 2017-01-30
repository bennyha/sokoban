package model.data.component;

import java.awt.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Baggage extends Component implements Serializable {

	public Baggage() {}
	public Baggage(Point position) { 
		super(position);
	}

	@Override
	public ComponentType getComponentType() {
		return ComponentType.BAGGAGE;
	}

	@Override
	public char getObjRep() {return '@';}

	@Override
	public boolean onTarget() {return onTarget;}
	
}
