package model.moveable;

import model.receivers.move.Move;

public interface Moveable {

	public void execute(Move moveCommand);
}
