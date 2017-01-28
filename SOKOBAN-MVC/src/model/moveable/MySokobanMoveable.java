package model.moveable;

import model.data.components.Baggage;
import model.data.components.Player;
import model.data.components.Components;
import model.data.components.ComponentsType;
import model.data.level.Level;
import model.receivers.move.Direction;
import model.receivers.move.Move;

public class MySokobanMoveable implements Moveable {

	private Level level;
	private Player player;
	private Direction direction;
	
	public MySokobanMoveable(Level level) { this.level = level; this.player = level.getPlayer(); }
	
	@Override
	public void execute(Move moveCommand) {
		
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

		if (level.getAdjacent(player.getPosition(),direction).getComponentType() == ComponentsType.BAGGAGE)
			return checkIfNeedPush();
		
		return true;
	}
	
	private boolean checkIfNeedPush() {
		
		Components potentialBox = level.getAdjacent(player.getPosition(),direction);
		Components potentialFloor = level.getAdjacent(potentialBox.getPosition(),direction);
		
		if (potentialBox.getComponentType() == ComponentsType.BAGGAGE) 
		{
			if (potentialFloor.getComponentType() == ComponentsType.FLOOR)
			{
				return true;
			}
			if (potentialFloor.getComponentType() == ComponentsType.TARGET)
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean wallCollision(Components worldObject, Direction direction) {
		
		if(level.getAdjacent(worldObject.getPosition(), direction).getComponentType() == ComponentsType.WALL)
		{
			return true;
		}
				
		return false;
	}
	
}