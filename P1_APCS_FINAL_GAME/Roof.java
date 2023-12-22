import engine.*;
import javafx.scene.image.Image;

public class Roof extends Actor {
	public Roof() {
		String path = getClass().getClassLoader().getResource("images/block.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(750);
		setFitHeight(50);
	}
	
	public Roof(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/block.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(750);
		setFitHeight(50);
	}
	
	@Override
	public void act(long n) {
		
	}
}
