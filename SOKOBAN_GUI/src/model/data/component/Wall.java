package model.data.component;

import java.awt.*;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Wall extends Component implements Serializable{

	public Wall() {}
	public Wall(Point position) { super(position); }

	@Override
	public ComponentType getComponentType() {
		return ComponentType.WALL;
		}

	@Override
	public char getObjRep() {
		return '#';
		}

	@Override
	public boolean onTarget() {
		return false;
		} // wall can't be on target


}
