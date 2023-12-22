import engine.Actor;
import javafx.scene.image.Image;

public class Checkmark extends Actor {

	public Checkmark() {
		String path = getClass().getClassLoader().getResource("images/checkmark.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(100);
		setFitHeight(100);
	}
	
	public Checkmark(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/checkmark.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(100);
		setFitHeight(100);
	}
	
	@Override
	public void act(long now) {
//		setX(getX()- 3);
	}
}
