package controller.commands;

import java.io.IOException;
import java.util.HashMap;

import model.Model;
import model.receivers.save.SaveLevel;
import model.receivers.save.SaveToObjFile;
import model.receivers.save.SaveToXMLFile;

public class SaveCommand implements Command {

	private HashMap<String,SaveLevel> levelSaverFactory = new HashMap<String,SaveLevel>();
	private String path = null;
	private String type = null;
	Model model = null;
	
	public SaveCommand(Model model) {
		this.model = model;
		levelSaverFactory.put("obj", new SaveToObjFile());
		levelSaverFactory.put("xml", new SaveToXMLFile());
	}
	
	public void setDefinitions(String[] definitions) {
		this.path = definitions[1];
		this.type = path.substring(path.lastIndexOf('.')+1);
	}
	
	@Override
	public void execute() throws IOException {

		if (!(type.equals("obj") || type.equals("xml")))
		{
			throw new IOException("incorrect file name");
		}
		levelSaverFactory.get(type).save(model.getLevel(), path);	
		System.out.println("completed");
	}

}
