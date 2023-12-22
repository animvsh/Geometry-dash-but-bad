import engine.*;
import javafx.scene.image.Image;

public class Stack extends Platform {
	public Stack() {
		String path = getClass().getClassLoader().getResource("images/Stack.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(200);
	}
	
	public Stack(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/Stack.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(200);
	}
	
	@Override
	public void act(long now) {
//		setX(getX()- 3);
	}
}
