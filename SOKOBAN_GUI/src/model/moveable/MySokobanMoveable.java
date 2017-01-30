package model.moveable;

import model.data.level.Level;
import model.data.component.*;
import model.receivers.move.Direction;
import model.receivers.move.Move;

public class MySokobanMoveable implements Moveable {

	private Level level;
	private Player player;
	private Direction direction;

	public MySokobanMoveable(Level level) {
		this.level = level; this.player = level.getPlayer();
		}
	
	@Override
	public void execute(Move moveCommand) throws Exception {
		
		this.direction = moveCommand.getDirection();
		
		if (checkIfMovePossible())
		{
			if (checkIfNeedPush())
			{
				push((Baggage)level.getAdjacent(player.getPosition(), direction),direction);
				moveCommand.move();
			}
			else 
			{
				moveCommand.move();
			}
		}
		level.setStepsCounter(level.getStepsCounter()+1);
	}
	
	private void push(Baggage baggage, Direction direction) {
				
		if (!wallCollision(baggage,direction))
		{
			Move pushCommand = new Move(level,baggage,direction);
			pushCommand.move();
		}
		
	}
	
	private boolean checkIfMovePossible() {
		if (wallCollision(player,direction))
			return false;

		if (level.getAdjacent(player.getPosition(),direction).getComponentType() == ComponentType.BAGGAGE)
			return checkIfNeedPush();
		
		return true;
	}
	
	private boolean checkIfNeedPush() {
		
		Component potentialBox = level.getAdjacent(player.getPosition(),direction);
		Component potentialFloor = level.getAdjacent(potentialBox.getPosition(),direction);
		
		if (potentialBox.getComponentType() == ComponentType.BAGGAGE) 
		{
			if (potentialFloor.getComponentType() == ComponentType.FLOOR)
			{
				return true;
			}
			if (potentialFloor.getComponentType() == ComponentType.TARGET)
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean wallCollision(Component component, Direction direction) {
		
		if(level.getAdjacent(Component.getPosition(), direction).getComponentType() ==ComponentType.WALL)
		{
			return true;
		}
				
		return false;
	}

}