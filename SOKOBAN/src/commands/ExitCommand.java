package commands;

public class ExitCommand implements Command {

	private boolean exit = true;
		
	@Override
	public void execute() {
		/*.. do nothing for now ..*/
	}
	
	public boolean getExit() {
		return exit;
	}
	
	

}