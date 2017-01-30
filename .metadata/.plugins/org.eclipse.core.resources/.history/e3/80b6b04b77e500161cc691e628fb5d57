package moveable;


import command.*;
import component.*;
import level.Level;
import receiver_move.Direction;
import receiver_move.Move;

public class Moveable {

	private Level level;
	private Player player;
	private Direction direction;
	
	public Moveable(Level level) { 
		this.level = level; 
		this.player = level.getPlayer();
		}
	
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

		if (level.getAdjacent(player.getPosition(),direction).getComponentType() == ComponentType.Baggage)
			return checkIfNeedPush();
		
		return true;
	}
	
	private boolean checkIfNeedPush() {
		
		Component potentialBaggege = level.getAdjacent(player.getPosition(),direction);
		Component potentialFloor = level.getAdjacent(potentialBaggege.getPosition(),direction);
		
		if (potentialBaggege.getComponentType() == ComponentType.Baggage) 
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
		
		if(level.getAdjacent(component.getPosition(), direction).getComponentType() == ComponentType.WALL)
		{
			return true;
		}
				
		return false;
	}
	
}