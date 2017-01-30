package view;

import model.Model;
import model.data.*;
import model.data.level.Level;
import model.receivers.display.Displayer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Scanner;
import com.sun.media.jfxmedia.MediaPlayer;
import controller.commands.Command;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class MyView extends Observable implements View {
	@FXML 
	private SokobanDisplayer GUIDisplayer;
	private MediaPlayer mediaPlayer;
	private BufferedReader reader;
    private PrintWriter writer;
    private String exitString;
    Stage stage;

    public MyView(BufferedReader reader, PrintWriter writer, String exitString) {
        this.reader = reader;
        this.writer = writer;
        this.exitString = exitString;
    }

    @Override
    public void display(Level l) {
        Displayer displayer;
        displayer = new MySokobanDisplay(l);
        displayer.display();
    }

    @Override
    public void setMoveMade(String s) {

    }

    @Override
    public void Finished() {
        System.out.println("Level Finished!");
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    public void displayMessage(Exception e) {
        System.out.println("Error: " + e);
    }

    @Override
    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String commandLine = "";
                do {
                    writer.print("Enter command: \n");
                    writer.flush();
                    try {
                        commandLine = reader.readLine();
                        String[] arr = commandLine.split(" ");
                        LinkedList<String> params = new LinkedList<String>();
                        for (String param : arr) {
                            params.add(param);
                        }
                        setChanged();
                        notifyObservers(params);


                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } while (!commandLine.equals(exitString));
            }
        }).start();
    }
    public Stage getStage() {
		return stage;
	}
    public void setStage(Stage stage) {
		this.stage = stage;
	}
	public SokobanDisplayer getGUIDisplayer() {return this.GUIDisplayer;}

	public void passException(Exception e) {
		Platform.runLater(() -> {
			if(e.getMessage().equals("save completed!")) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Save File");
				alert.setHeaderText("The file was saved successfully");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
			else if(e.getMessage().equals("good job..")) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Level Completed");
				alert.setHeaderText("Level is completed!");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
			else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Error occurred!");
				alert.setContentText(e.getMessage());
				alert.showAndWait();
			}
		});
	}
	public void pauseMusic() {mediaPlayer.pause();}

	public void playMusic() {mediaPlayer.play();}

	private void loadAndPlayMusic() {
		URL fileUrl = MyView.class.getResource("/resources/music/01-maka-fushigi-adventure-.mp3");
		javafx.scene.media.Media musicFile = new javafx.scene.media.Media(fileUrl.toExternalForm());
		this.mediaPlayer = new MediaPlayer(musicFile);
		this.mediaPlayer.setAutoPlay(true);
	}

}
