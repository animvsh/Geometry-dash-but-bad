import engine.*;
import javafx.scene.image.Image;

public class Spike extends Danger {

	public Spike() {
		String path = getClass().getClassLoader().getResource("images/Spike.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(49);
	}
	
	public Spike(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/Spike.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(50);
	}
	
	@Override
	public void act(long now) {
//		setX(getX() - 3);
	}
}
