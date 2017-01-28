package receiver_save;

import java.io.IOException;

import level.Level;

public interface SaveLevel {

	public void save(Level level, String path) throws IOException;
	
}