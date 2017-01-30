package command;

import receiver_move.Move;

public class MoveCommand implements Command {

	private Move move = null;
	
	public MoveCommand(Move move) {	
		this.move = move; 
	}
	
	@Override
	public void execute() {	
		move.move(); 
	}

	public Move getMoveMaker () {
		return move;
	}
	
}