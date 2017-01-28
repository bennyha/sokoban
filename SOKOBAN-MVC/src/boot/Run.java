package boot;

import controller.SokobanController;
import controller.server.CLI;
import controller.server.MyServer;
import model.MyModel;
import view.MyView;

public class Run {
	
	public static void main(String args[]) {
		
		MyView myView = new MyView();
		MyModel myModel = new MyModel();
		SokobanController sokobanController = new SokobanController(myModel,myView);
		myView.addObserver(sokobanController);
		myModel.addObserver(sokobanController);

		sokobanController.getController().start();
		if(args.length == 2){
			if(args[0].equals("-server")) {
				/* set the server */
				sokobanController.setServer(new MyServer(Integer.parseInt(args[1]),new CLI()));			
				((CLI)(sokobanController.getServer()).getCH()).addObserver(sokobanController);
				sokobanController.getServer().start();
			}
		}
			
	}
		
}
	
	

