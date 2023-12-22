import engine.*;
import javafx.scene.image.Image;

public class Background extends Actor{
	
	public Background() {
		String path = getClass().getClassLoader().getResource("images/background.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(750);
		setFitHeight(500);
	}
	
	public Background(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/background.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(750);
		setFitHeight(500);
	}
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
}
