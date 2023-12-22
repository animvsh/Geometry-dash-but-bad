import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class GameDriver extends Application {
	
	Player player;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception { 		// TODO Auto-generated method stub
		VBox root = new VBox();
		
		GameWorld world = new GameWorld();
		world.setMinWidth(750);
		world.setMinHeight(500);
		MenuItem i = new MenuItem("How to Play");
		Menu m = new Menu("Help");
		m.getItems().add(i);
		i.setOnAction(new Handler());
		MenuBar bar = new MenuBar(m);
		root.getChildren().addAll(bar, world);
		Scene scene = new Scene(root);
		stage.setMinHeight(500);
		stage.setMinWidth(750);
		stage.setTitle("Geometry Dash");
		stage.setScene(scene);
		stage.show();

//		String path = getClass().getResource("sounds/moogcity.mp3").getPath();
//		path = "C:/Users/Shane/arcade-engine-2022_p1_team_9/src/sounds/moogcity.mp3";
//		Media media = new Media(new File(path).toURI().toString()); 
//		MediaPlayer player = new MediaPlayer(media);
//		player.setAutoPlay(true);
//		System.out.println(player.getError());
	}
	
	
	private class Handler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			WebView view = new WebView();
			File f = new File("how.html");
			view.getEngine().load("file:///" + f.getAbsolutePath());
			
			Scene sc = new Scene(view);
			Stage s = new Stage();
			s.setTitle("How to Play");
			
			s.setScene(sc);
			s.showAndWait();
		}
		
	}
}
