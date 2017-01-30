package command;

import java.io.IOException;
import java.util.HashMap;

import level.Level;
import receiver_load.*;

public class LoadCommand implements Command {

	private HashMap<String,LoadLevel> levelLoader = new HashMap<String,LoadLevel>();
	private String path = null;
	private Level level = null;
	private String type = null;
	
	public LoadCommand(String path) {
		this.path = path;
		this.type = path.substring(path.lastIndexOf('.')+1);
		levelLoader.put("txt",new LoadTextLevel());
		levelLoader.put("obj",new LoadObjectLevel());
		levelLoader.put("xml",new LoadXMLLevel());
	}
	
	@Override
	public void execute() throws IOException {
		if (!(type.equals("txt") || type.equals("obj") || type.equals("xml")))
		{
			System.out.println("Enter diferent FileName");
			return;
		}
		
		level = levelLoader.get(type).load(path);
		System.out.println("load complete");
	}

	public Level getLevel() {
		return level;
	}
	
	public void setPath(String path){
		this.path = path;
	}
	

}