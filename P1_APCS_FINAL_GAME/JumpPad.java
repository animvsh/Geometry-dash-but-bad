import engine.Actor;
import javafx.scene.image.Image;

public class JumpPad extends Actor {

	public JumpPad() {
		String path = getClass().getClassLoader().getResource("images/launchPad.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(10);
	}
	
	public JumpPad(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/launchPad.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(10);
	}
	
	@Override
	public void act(long now) {
//		setX(getX()- 3);
	}
}
