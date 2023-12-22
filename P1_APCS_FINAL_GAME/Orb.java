import engine.Actor;
import javafx.scene.image.Image;

public class Orb extends Actor {

	public Orb() {
		String path = getClass().getClassLoader().getResource("images/orb.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(50);
	}
	
	public Orb(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/orb.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(50);
	}
	
	@Override
	public void act(long now) {
//		setX(getX()- 3);
	}
}
