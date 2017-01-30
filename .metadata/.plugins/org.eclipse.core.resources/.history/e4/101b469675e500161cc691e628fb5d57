package component;

import java.awt.Point;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Player extends Component implements Serializable{

	public Player() {}
	public Player(Point position) {	
		super(position); 
	}
	
	@Override
	public ComponentType getComponentType() {
		return ComponentType.PLAYER;
	}

	@Override
	public char getObjRep() {
		return 'A';
	}

	@Override
	public boolean onTarget() {
		return onTarget;
	}

}