package commands;

import java.io.IOException;
import java.util.HashMap;

import level.Level;
import receiver.load.LoadLevel;
import receiver.load.LoadObjectLevel;
import receiver.load.LoadTextLevel;
import receiver.load.LoadXMLLevel;

public class LoadCommand implements Command {

	private HashMap<String,LoadLevel> levelLoaderFactory = new HashMap<String,LoadLevel>();
	private String path = null;
	private Level level = null;
	private String type = null;
	
	public LoadCommand(String path) {
		this.path = path;
		this.type = path.substring(path.lastIndexOf('.')+1);
		levelLoaderFactory.put("txt",new LoadTextLevel());
		levelLoaderFactory.put("obj",new LoadObjectLevel());
		levelLoaderFactory.put("xml",new LoadXMLLevel());
	}
	
	@Override
	public void execute() throws IOException {
		if (!(type.equals("txt") || type.equals("obj") || type.equals("xml")))
		{
			System.out.println("invalid file name");
			return;
		}
		
		level = levelLoaderFactory.get(type).load(path);
		System.out.println("load completed!");
	}

	public Level getLevel() {
		return level;
	}
	
	public void setPath(String path){
		this.path = path;
	}
	

}