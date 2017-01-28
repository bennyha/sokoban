package policy;

import commands.MoveCommand;
import level.Level;
import receiver.move.Direction;
import receiver.move.Move;
import components.Baggage;
import components.Player;
import components.WorldObject;
import components.WorldObjectType;

public class MySokobanPolicy {

	private Level level;
	private Player player;
	private Direction direction;
	
	public MySokobanPolicy(Level level) { this.level = level; this.player = level.getPlayer(); }
	
	public void execute(MoveCommand moveCommand) {
		
		this.direction = moveCommand.getMoveMaker().getDirection();
		
		if (checkIfMovePossible())
		{
			if (checkIfNeedPush())
			{
				push((Baggage)level.getAdjacent(player.getPosition(), direction),direction);
				moveCommand.execute();
			}
			else 
			{
				moveCommand.execute();
			}
		}
	}
	
	private void push( Baggage Baggage, Direction direction) {
				
		if (!wallCollision(Baggage,direction))
		{
			MoveCommand pushCommand = new MoveCommand(new Move(level,Baggage,direction));
			pushCommand.execute();
		}
		
	}
	
	private boolean checkIfMovePossible() {
		if (wallCollision(player,direction))
			return false;

		if (level.getAdjacent(player.getPosition(),direction).getWorldObjectType() == WorldObjectType.Baggage)
			return checkIfNeedPush();
		
		return true;
	}
	
	private boolean checkIfNeedPush() {
		
		WorldObject potentialBox = level.getAdjacent(player.getPosition(),direction);
		WorldObject potentialFloor = level.getAdjacent(potentialBox.getPosition(),direction);
		
		if (potentialBox.getWorldObjectType() == WorldObjectType.Baggage) 
		{
			if (potentialFloor.getWorldObjectType() == WorldObjectType.FLOOR)
			{
				return true;
			}
			if (potentialFloor.getWorldObjectType() == WorldObjectType.TARGET)
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean wallCollision(WorldObject worldObject, Direction direction) {
		
		if(level.getAdjacent(worldObject.getPosition(), direction).getWorldObjectType() == WorldObjectType.WALL)
		{
			return true;
		}
				
		return false;
	}
	
}