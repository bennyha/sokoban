package model.receivers.save;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import model.data.level.Level;

public class SaveToXMLFile implements SaveLevel{

	@Override
	public void save(Level level, String path) throws IOException {
		
		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
		
		encoder.writeObject(level);
		
		encoder.close();	
		
	}
}
