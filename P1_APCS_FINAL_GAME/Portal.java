import engine.Actor;
import javafx.scene.image.Image;

public class Portal extends Actor {

	public Portal() {
		String path = getClass().getClassLoader().getResource("images/portal.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(100);
	}
	
	public Portal(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/portal.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(100);
	}
	
	public void shiftToTheLeft(int move) {
		setX(getX()-8);
		PortalTop p = getOneIntersectingObject(PortalTop.class);
		if (p != null) {
			p.shiftToLeft(8);
			//System.out.println("Portal: ("+getX()+", "+getY()+")\tSpike: ("+p.getX()+", "+p.getY()+")");
		} else {
			System.out.println("Failed");
		}
	}
	
	@Override
	public void act(long now) {
//		setX(getX()- 3);
	}
}
