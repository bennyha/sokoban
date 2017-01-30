package model.data.component;

import java.awt.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Target extends Component implements Serializable{

	public Target() {}
	public Target(Point position) {	super(position); }

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
		} // target can't be on target

}
