package commands;

import receiver.move.Move;

public class MoveCommand implements Command {

	private Move moveMaker = null;
	
	public MoveCommand(Move move) {	this.moveMaker = move; }
	
	@Override
	public void execute() {	moveMaker.move(); }

	public Move getMoveMaker () {
		return moveMaker;
	}
	
}