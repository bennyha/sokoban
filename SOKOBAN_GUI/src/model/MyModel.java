package model;

import model.data.level.Level;
import model.moveable.*;
import model.receivers.move.Direction;
import model.receivers.move.Move;
import view.CLI;

import java.util.Observable;

public class MyModel extends Observable implements Model {

	CLI cli;
	private Level level = null;
	private Move moveUp = null;
	private Move moveDown = null;
	private Move moveRight = null;
	private Move moveLeft = null;
	private Moveable moveable = null;
	private String currentLevelPath= null;

	@Override
	public void move(Direction direction) throws Exception {
		if (level == null){
			//System.out.println("there is no level loaded");
			return;
		}
		
		switch(direction) {
		
		case UP:	moveable.execute(moveUp);
					break;
			 
		case DOWN:  moveable.execute(moveDown);
					break;
			
		case RIGHT: moveable.execute(moveRight);
					break;
			
		case LEFT:  moveable.execute(moveLeft);
				   	break;
			
		default:	  System.out.println("invalid direction");
					  break;
		}		
		setChanged();
		notifyObservers("display");
	
	}

	@Override
	public Level getLevel() {return level;}

	@Override
	public void setLevel(Level level) {
		this.level = level;
		moveable = new MySokobanMoveable(level);
	
		moveUp = new Move(level,level.getPlayer(),Direction.UP);
		moveDown = new Move(level,level.getPlayer(),Direction.DOWN);
		moveLeft = new Move(level,level.getPlayer(),Direction.LEFT);
		moveRight = new Move(level,level.getPlayer(),Direction.RIGHT);
		
		setChanged();
		notifyObservers("display");
		
	}

	public void setCurrentLevelPath(String path) {this.currentLevelPath=path;}

	public void restartLevel() {
		String loadCommand = "load "+currentLevelPath;
		setChanged();
		notifyObservers(loadCommand);
	}
	@Override
	public void ExitCommand() {
	}
	@Override
	public Level getCurrentLevel() {
		return this.level;
	}
	@Override
	public void setCli(CLI cli) {
		this.cli = cli;
	}
	


	
	
}