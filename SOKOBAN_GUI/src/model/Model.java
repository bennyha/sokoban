package model;

import model.data.level.Level;
import model.receivers.move.Direction;
import view.CLI;

public interface Model {

	Level getLevel();
	void setLevel(Level level);
	void move(Direction direction) throws Exception;
	void ExitCommand();
	Level getCurrentLevel();
	void setCli(CLI cli);

}
