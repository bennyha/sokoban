
package level;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import receiver.move.Direction;
import components.Player;
import components.WorldObject;
import components.WorldObjectType;

@SuppressWarnings("serial")
public class Level implements Serializable {

	private ArrayList<ArrayList<WorldObject>> grid;
	private ArrayList<Point> solutionCoordinates = new ArrayList<Point>();
	private Player player = null;
	
	public Level() {}
	public Level(ArrayList<ArrayList<WorldObject>> grid) {
		try 
		{			
			this.grid = grid;
			Point tempPlayerPosition = getPlayer().getPosition();
			this.setPlayer(new Player(tempPlayerPosition));
			findSolCoordinates();	
		}
		catch (Exception s) { System.out.println(s); }
	}
	
	// Finding all TARGETs coordinates
	public void findSolCoordinates() {
		for(int i = 0; i < grid.size(); i++) 
			for(int j = 0; j < grid.get(i).size(); j++) {
				WorldObject w = grid.get(i).get(j);
				if (w.getWorldObjectType() == WorldObjectType.TARGET) { solutionCoordinates.add(w.getPosition()); }
			}
	}
	
	public Player getPlayer()
	{
		if (player != null)
		{
			return player;
		}
		for (int i = 0; i < grid.size(); i++)
		{
			for (int j = 0; j < grid.get(i).size(); j++)
			{
				if (grid.get(i).get(j).getWorldObjectType() == WorldObjectType.PLAYER)
					return ((Player)grid.get(i).get(j));
			}
		}
		return null;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public final ArrayList<ArrayList<WorldObject>> getGrid() {
		return grid;
	}
	
	public void setGrid(ArrayList<ArrayList<WorldObject>> grid) {
		this.grid = grid;
	}
	
	public List<Point> getSolutionCoordinates() {
		return solutionCoordinates;
	}
	
	public void setSolutionCoordinates(ArrayList<Point> solutionCoordinates) {
		this.solutionCoordinates = solutionCoordinates;
	}
	
	public WorldObject getWorldObject(Point position) {
		return grid.get((int)position.getX()).get((int)position.getY());
	}
	
	// Return adjacent of the given position and direction
	public WorldObject getAdjacent(Point position, Direction direction) {
				
		int x = (int)position.getX();
		int y = (int)position.getY();
		
		switch (direction) {
		
			case UP:	return 	grid.get(x-1).get(y);	
			
			case DOWN:	return 	grid.get(x+1).get(y);	
			
			case LEFT:	return 	grid.get(x).get(y-1);
			
			case RIGHT:	return 	grid.get(x).get(y+1);
			
			default:	return null;
		} 
	}
	
}