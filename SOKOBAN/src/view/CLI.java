package view;

import java.io.IOException;
import java.util.Scanner;

import commands.DisplayCommand;
import commands.ExitCommand;
import commands.LoadCommand;
import commands.MoveCommand;
import commands.SaveCommand;
import level.Level;
import policy.MySokobanPolicy;
import receiver.move.Direction;
import receiver.move.Move;

public class CLI {

	private Scanner sc = new Scanner(System.in);
	private String userInput = null;
	private Level level = null;
	private MoveCommand moveUp = null;
	private MoveCommand moveDown = null;
	private MoveCommand moveRight = null;
	private MoveCommand moveLeft = null;
	private MySokobanPolicy policy = null;
	private DisplayCommand display = null;
	private boolean exit = false;
	
	public void run() throws IOException {
				
		System.out.println("Welcome to Sokoban game!");
		System.out.println("game commands are:"+"\n"
							+">Load 'filepath'"+"\n"
							+">Display"+"\n"
							+">Move {up, down, left, right}"+"\n"
							+">Save 'filepath'"+" {*.obj, *.xml}"+"\n"
							+">Exit"+"\n"+"\n");
		
		while (!exit) {
			userInput = sc.nextLine();
			userInput = userInput.toLowerCase();
			String[] commands = userInput.split(" ");
			
			switch(commands[0]) { 
			
			case ">exit": 		exit();
								break;
			
			case ">load":		if (commands.length < 2) {
									System.out.println("no path");
									break;
								}
								load(commands[1]);
								break;
								
			case ">display":	display();
								break;
			
			case ">move":		if (commands.length < 2) {
									System.out.println("invalid direction");
									break;
								}
								move(commands[1]);
								break;
				
			case ">save":		if (commands.length < 2) {
									System.out.println("no path");
									break;
								}
								save(commands[1]);
								break;
			
			default:			System.out.println("invalid command");
								break;
			
			}

		}
		sc.close();
		
	}
	
	private void load(String path) throws IOException {
		
		LoadCommand loadCommand = new LoadCommand(path);
		loadCommand.execute();
		if (loadCommand.getLevel() == null)
			return;
		level = loadCommand.getLevel();
		
		moveUp = new MoveCommand(new Move(level,level.getPlayer(),Direction.UP));
		moveDown = new MoveCommand(new Move(level,level.getPlayer(),Direction.DOWN));
		moveLeft = new MoveCommand(new Move(level,level.getPlayer(),Direction.LEFT));
		moveRight = new MoveCommand(new Move(level,level.getPlayer(),Direction.RIGHT));
		
		policy = new MySokobanPolicy(level);
		
		display = new DisplayCommand(level);
		
	}
	
	private void save(String path) throws IOException {
		
		if (level == null){
			System.out.println("there is no level loaded");
			return;
		}
		SaveCommand saveCommand = new SaveCommand(level,path);
		saveCommand.execute();
		
	}
	
	private void move(String direction) {
		
		if (level == null){
			System.out.println("there is no level loaded");
			return;
		}
		
		switch(direction) {
		
		case "up":	  policy.execute(moveUp);
					  display();
					  break;
			 
		case "down":  policy.execute(moveDown);
					  display();
					  break;
			
		case "right": policy.execute(moveRight);
					  display();
					  break;
			
		case "left":  policy.execute(moveLeft);
				      display();
					  break;
			
		default:	  System.out.println("invalid direction");
					  break;
		}
			
	}
	
	private void display() {
		
		if(display == null)
		{
			System.out.println("there is no level loaded");
			return;
		}
		display.execute();
	}
	
	private void exit() {
		
		ExitCommand exitCommand = new ExitCommand();
		exit = exitCommand.getExit();
		System.out.println("bye..");
	}
	
	public boolean isExit(){
		return exit;
	}
	
	
}