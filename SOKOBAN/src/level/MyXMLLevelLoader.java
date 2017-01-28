package level;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyXMLLevelLoader implements LevelLoader {

	@Override
	public Level loadLevel(InputStream in) throws IOException {

		XMLDecoder decoder = new XMLDecoder(new BufferedInputStream((in)));
		Level level = (Level)decoder.readObject();
		decoder.close();
		return level;
	}

}