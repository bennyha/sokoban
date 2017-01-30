package view;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.data.level.*;

public class SokobanDisplayer extends Canvas {
private Level lvl;
private int maxHeight;
private int maxWidth;
private GraphicsContext gc=getGraphicsContext2D();


public SokobanDisplayer(){
	setWidth(300);
	setHeight(300);
}
public void setLevel(Level l)
{
	this.lvl=l;
}

public void getWH(){
	System.out.println(getWidth()+","+getHeight());
}
 void redraw() throws Exception {
	if(lvl == null)
		return;
	double displayerHeight = this.getHeight();
	double displayerWidth = this.getWidth();
	double cellHeight = displayerHeight/maxHeight;
	double cellWidth = displayerWidth/maxWidth;
	
	GraphicsContext gc = getGraphicsContext2D();

	Image wall = new Image(getClass().getResourceAsStream("/resources/images/wall.jpg"));
	Image player = new Image(getClass().getResourceAsStream("/resources/images/player.gif"));
	Image target = new Image(getClass().getResourceAsStream("/resources/images/target.png"));
	Image baggage = new Image(getClass().getResourceAsStream("/resources/images/baggage.png"));
	Image floor = new Image(getClass().getResourceAsStream("/resources/images/floor.jpg"));

	gc.clearRect(0, 0, displayerWidth, displayerHeight);
	
	for(int i = 0; i < lvl.getGrid().size(); i++) {
		for(int j = 0; j < lvl.getGrid().get(i).size(); j++) {
			char c = lvl.getGrid().get(i).get(j).getObjRep();
			if(c == ' '){
				gc.drawImage(floor,cellWidth*j, cellHeight*i, cellWidth, cellHeight);
			}
			if(c == '#'){
				gc.drawImage(wall,cellWidth*j, cellHeight*i, cellWidth, cellHeight);
			}
			if(c == 'o'){
				gc.drawImage(target,cellWidth*j, cellHeight*i, cellWidth, cellHeight);
			}
			if(c == '@'){
				gc.drawImage(baggage,cellWidth*j, cellHeight*i, cellWidth, cellHeight);
			}
			if(c == 'A'){
				gc.drawImage(player,cellWidth*j, cellHeight*i, cellWidth, cellHeight);
			}

		}
	}
	if(lvl.checkIfWin()) {
		throw new Exception("good job..");
	}
	Platform.runLater(() -> requestFocus());
}

void clearCanvas()
{
	gc.clearRect(0, 0, getWidth(), getHeight());
}
}
