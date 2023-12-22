import engine.*;
import javafx.scene.image.Image;

public class Progress extends Actor {

	public Progress() {
		String path = getClass().getClassLoader().getResource("images/progress.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(1);
		setFitHeight(27);
	}
	
	public Progress(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/progress.png").toString();
		Image img = new Image(path);
		setImage(img);
		setX(x);
		setY(y);
		setFitWidth(1);
		setFitHeight(27);
	}
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}

}
