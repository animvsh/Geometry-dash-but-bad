import engine.*;
import javafx.scene.image.Image;

public class Floor extends Actor {
	public Floor() {
		String path = getClass().getClassLoader().getResource("images/block.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(750);
		setFitHeight(50);
	}
	
	public Floor(int x, int y) {
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
