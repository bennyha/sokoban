package receiver_save;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import level.Level;

public class SaveToObjFile implements SaveLevel {

	@Override
	public void save(Level level, String path) throws IOException {
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
		
		out.writeObject(level);
		
		out.close();

	}
}