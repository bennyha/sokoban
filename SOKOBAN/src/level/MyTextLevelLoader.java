package level;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import component.*;


public class MyTextLevelLoader implements LevelLoader{

	BufferedReader reader;
	
	public MyTextLevelLoader() {}
	
	@Override
	public Level loadLevel(InputStream input) throws IOException  
	{	
		if (!(input instanceof FileInputStream))
			throw new IOException("input is not FileInputStream instance");
	
		this.reader = new BufferedReader(new InputStreamReader(input));
		ArrayList<ArrayList<Component>> level = new ArrayList<ArrayList<Component>>();
		String line;
		int i = 0;
		while ((line = reader.readLine()) != null) 
		{
			level.add(new ArrayList<Component>());

			for(int j = 0; j < line.length(); j++)
			{
				if (line.charAt(j) == '#')
					level.get(i).add(new Wall(new Point(i,j)));
				if (line.charAt(j) == '@')
					level.get(i).add(new Baggage(new Point(i,j)));
				if (line.charAt(j) == 'o')
					level.get(i).add(new Target(new Point(i,j)));
				if (line.charAt(j) == ' ')
					level.get(i).add(new Floor(new Point(i,j)));
				if (line.charAt(j) == 'A')
					level.get(i).add(new Player(new Point(i,j)));
			}
			i++;
		}
		reader.close();		
		Level newLevel = new Level(level);
		return newLevel;
	}
}
	