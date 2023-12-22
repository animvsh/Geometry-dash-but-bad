import engine.Actor;
import javafx.scene.image.Image;

public class PortalTop extends Actor {
	private boolean isUsed;

	public PortalTop() {
		String path = getClass().getClassLoader().getResource("images/portalTop.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(100);
		isUsed = false;
	}
	
	public PortalTop(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/portalTop.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(100);
		isUsed = false;
	}
	
	public void shiftToLeft(double amt) {
		setX(getX()-amt);
	}
	
	public boolean isUsed() {
		return isUsed;
	}
	
	public void use() {
		isUsed = true;
	}
	
	@Override
	public void act(long now) {
//		setX(getX()- 3);
	}
}
