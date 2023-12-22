import engine.*;
import javafx.scene.image.Image;

public class Block extends Platform {
	public Block() {
		String path = getClass().getClassLoader().getResource("images/block.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(50);
	}
	
	public Block(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/block.png").toString();
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
