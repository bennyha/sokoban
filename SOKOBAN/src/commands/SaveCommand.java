package commands;

import java.io.IOException;
import java.util.HashMap;

import level.Level;
import receiver.save.SaveLevel;
import receiver.save.SaveToObjFile;
import receiver.save.SaveToXMLFile;

public class SaveCommand implements Command {

	private HashMap<String,SaveLevel> levelSaverFactory = new HashMap<String,SaveLevel>();
	private Level level = null;
	private String path = null;
	private String type = null;
	
	
	public SaveCommand(Level level, String path) {
		this.level = level;
		this.path = path;
		this.type = path.substring(path.lastIndexOf('.')+1);
		levelSaverFactory.put("obj", new SaveToObjFile());
		levelSaverFactory.put("xml", new SaveToXMLFile());
	}
	
	@Override
	public void execute() throws IOException {

		if (!(type.equals("obj") || type.equals("xml")))
		{
			System.out.println("invalid file name");
			return;
		}
		levelSaverFactory.get(type).save(level, path);	
		System.out.println("save completed!");
	}

}