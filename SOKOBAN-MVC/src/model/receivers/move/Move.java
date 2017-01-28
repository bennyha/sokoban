package model.receivers.move;

import java.awt.Point;

import model.data.components.Floor;
import model.data.components.Target;
import model.data.components.Components;
import model.data.components.ComponentsType;
import model.data.level.Level;

public class Move {

	protected Level level;
	protected Components component;
	Direction direction;
	
	public Move(Level level, Components component, Direction direction) {
		this.level = level;
		this.component = component;
		this.direction = direction;
	}
	
	
	public void move() {

		// Current component position
		Point currentPosition = component.getPosition();
		int x = (int)currentPosition.getX();
		int y = (int)currentPosition.getY();

		// Current component onTarget status
		boolean onTarget = component.getOnTarget();

		// Check if the WorldObject is going to cover something
		if (level.getAdjacent(currentPosition,direction).getComponentType() == ComponentsType.TARGET)
			component.setOnTarget(true);
		if (level.getAdjacent(currentPosition,direction).getComponentType() == ComponentsType.FLOOR)
			component.setOnTarget(false);

		// Making a move
		makeMove(direction);

		// Recovering a covered place
		if (onTarget) { level.getGrid().get(x).set(y, new Target(currentPosition)); }
		if (!onTarget) { level.getGrid().get(x).set(y, new Floor(currentPosition)); }

		
	}
	
	public void makeMove(Direction direction){

		int x = (int)component.getPosition().getX();
		int y = (int)component.getPosition().getY();

		switch (direction) {
			case UP: 	level.getGrid().get(x-1).set(y, component);
						component.setPosition(new Point(x-1,y));
						break;
						
			case DOWN:	level.getGrid().get(x+1).set(y, component);
						component.setPosition(new Point(x+1,y));
						break;
						
			case LEFT:  level.getGrid().get(x).set(y-1, component);
						component.setPosition(new Point(x,y-1));
						break;
						
			case RIGHT:	level.getGrid().get(x).set(y+1, component);
						component.setPosition(new Point(x,y+1));
						break;
		}
	}
	
	public Direction getDirection(){
		return direction;
	}
	
}
