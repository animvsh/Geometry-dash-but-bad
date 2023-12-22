import engine.Actor;
import javafx.scene.image.Image;

public class End extends Actor {
	
	public End() {
		String path = getClass().getClassLoader().getResource("images/block.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(450);
	}
	
	public End(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/block.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(450);
	}
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}

}
