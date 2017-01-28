
package level;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import component.Component;
import receiver_move.Direction;
import component.Player;
import component.Component;
import component.ComponentType;

public class Level implements Serializable {

	private ArrayList<ArrayList<Component>> level;
	private ArrayList<Point> points = new ArrayList<Point>();
	private Player player = null;
	
	public Level() {}
	public Level(ArrayList<ArrayList<Component>> level) {
		try 
		{			
			this.level = level;
			Point tempPlayerPosition = getPlayer().getPosition();
			this.setPlayer(new Player(tempPlayerPosition));
			findTargetsPoints();	
		}
		catch (Exception s) { 
			System.out.println(s); 
		}
	}
	
	public void findTargetsPoints() {
		for(int i = 0; i < level.size(); i++) 
			for(int j = 0; j < level.get(i).size(); j++) {
				Component w = level.get(i).get(j);
				if (w.getComponentType() == ComponentType.TARGET) { 
					points.add(w.getPosition()); 
				}
			}
	}
	
	public Player getPlayer()
	{
		if (player != null)
		{
			return player;
		}
		for (int i = 0; i < level.size(); i++)
		{
			for (int j = 0; j < level.get(i).size(); j++)
			{
				if (level.get(i).get(j).getComponentType() == ComponentType.PLAYER)
					return ((Player)level.get(i).get(j));
			}
		}
		return null;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public final ArrayList<ArrayList<Component>> getLevel() {
		return level;
	}
	
	public void setlevel(ArrayList<ArrayList<Component>> level) {
		this.level = level;
	}
	
	public List<Point> getSolutionCoordinates() {
		return points;
	}
	
	public void setPoints(ArrayList<Point> solutionCoordinates) {
		this.points = solutionCoordinates;
	}
	
	public Component getComponent(Point position) {
		return level.get((int)position.getX()).get((int)position.getY());
	}
	
	// Return adjacent of the given position and direction
	public Component getAdjacent(Point position, Direction direction) {
				
		int x = (int)position.getX();
		int y = (int)position.getY();
		
		switch (direction) {
		
			case UP:
				return level.get(x-1).get(y);	
			
			case DOWN:
				return 	level.get(x+1).get(y);	
			
			case LEFT:
				return 	level.get(x).get(y-1);
			
			case RIGHT:
				return 	level.get(x).get(y+1);
			
			default:
				return null;
		} 
	}
	
}