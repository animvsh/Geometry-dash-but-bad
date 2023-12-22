import engine.*;
import javafx.scene.image.Image;

public class Platform extends Actor {

	public Platform() {
		String path = getClass().getClassLoader().getResource("images/platform.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(25);
	}
	
	public Platform(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/platform.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(25);
	}
	
	@Override
	public void act(long now) {
//		setX(getX()- 3);
	}

}
