package model.data.level;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class MyObjectLevelLoader implements LevelLoader {
		
	@Override
	public Level loadLevel(InputStream input) throws IOException {
		if (!(input instanceof ObjectInputStream))
			throw new IOException("input is not ObjectInputStream instance");
		try 
		{
			Level level = (Level)(((ObjectInputStream)input).readObject());
			return level;
		} catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

}
