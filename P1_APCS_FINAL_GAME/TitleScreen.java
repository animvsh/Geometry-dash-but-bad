import engine.Actor;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class TitleScreen extends Actor {
	
	public TitleScreen() {
		String path = getClass().getClassLoader().getResource("images/TitleScreen2.png").toString();
		//String path = getClass().getClassLoader().getResource("images/Spike.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(750);
		setFitHeight(500);
	}
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if (getWorld().isKeyPressed(KeyCode.ENTER)) {
			GameWorld w = (GameWorld)getWorld();
			w.menuScreen();
		}
	}
}
