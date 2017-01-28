package model.receivers.load;

import java.io.IOException;

import model.data.level.Level;

public interface LoadLevel {

	public Level load(String path) throws IOException;
	
}
