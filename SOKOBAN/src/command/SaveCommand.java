package command;

import java.io.IOException;
import java.util.HashMap;

import level.Level;
import receiver_save.*;

public class SaveCommand implements Command {

	private HashMap<String,SaveLevel> levelSave = new HashMap<String,SaveLevel>();
	private Level level = null;
	private String path = null;
	private String type = null;
	
	
	public SaveCommand(Level level, String path) {
		this.level = level;
		this.path = path;
		this.type = path.substring(path.lastIndexOf('.')+1);
		levelSave.put("obj", new SaveToObjFile());
		levelSave.put("xml", new SaveToXMLFile());
	}
	
	@Override
	public void execute() throws IOException {

		if (!(type.equals("obj") || type.equals("xml")))
		{
			System.out.println("Enter different FileName ");
			return;
		}
		levelSave.get(type).save(level, path);	
		System.out.println("save complete!");
	}

}