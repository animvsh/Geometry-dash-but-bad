import engine.Actor;
import javafx.scene.image.Image;

public class PurpleOrb extends Orb {
	
	public PurpleOrb() {
		String path = getClass().getClassLoader().getResource("images/PurpleOrb.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(50);
	}
	
	public PurpleOrb(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/PurpleOrb.png").toString();
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
