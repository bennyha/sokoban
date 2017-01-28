package model.data.level;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.data.components.Player;
import model.data.components.Components;
import model.data.components.ComponentsType;
import model.receivers.move.Direction;

@SuppressWarnings("serial")
public class Level implements Serializable {

	private ArrayList<ArrayList<Components>> grid;
	private ArrayList<Point> points = new ArrayList<Point>();
	private Player player = null;
	
	public Level() {}
	public Level(ArrayList<ArrayList<Components>> grid) {
		try 
		{			
			this.grid = grid;
			Point tempPlayerPosition = getPlayer().getPosition();
			this.setPlayer(new Player(tempPlayerPosition));
			findPoints();	
		}
		catch (Exception s) { System.out.println(s); }
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
				if (grid.get(i).get(j).getComponentType() == ComponentsType.PLAYER)
					return ((Player)grid.get(i).get(j));
			}
		}
		return null;
	}
	
	// Finding all TARGETs coordinates
	public void findPoints() {
		for(int i = 0; i < grid.size(); i++) 
			for(int j = 0; j < grid.get(i).size(); j++) {
				Components w = grid.get(i).get(j);
				if (w.getComponentType() == ComponentsType.TARGET) { 
					points.add(w.getPosition()); 
					}
			}
	}

	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public final ArrayList<ArrayList<Components>> getGrid() {
		return grid;
	}
	
	public void setGrid(ArrayList<ArrayList<Components>> grid) {
		this.grid = grid;
	}
	
	public List<Point> getSolutionCoordinates() {
		return points;
	}
	
	public void setSolutionCoordinates(ArrayList<Point> points) {
		this.points = points;
	}
	
	public Components getWorldObject(Point position) {
		return grid.get((int)position.getX()).get((int)position.getY());
	}
	
	// Return adjacent of the given position and direction
	public Components getAdjacent(Point position, Direction direction) {
				
		int x = (int)position.getX();
		int y = (int)position.getY();
		
		switch (direction) {
		
			case UP:	return 	grid.get(x-1).get(y);	
			
			case DOWN:	return 	grid.get(x+1).get(y);	
			
			case LEFT:	return 	grid.get(x).get(y-1);
			
			case RIGHT:	return 	grid.get(x).get(y+1);
			
			default:	
				return null;
		} 
	}
	
}
