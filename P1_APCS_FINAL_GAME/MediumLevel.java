import engine.*;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class MediumLevel extends Actor {

	public MediumLevel() {
		String path = getClass().getClassLoader().getResource("images/MediumLevel1.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(200);
		setFitHeight(100);
		MyMouseHandler m = new MyMouseHandler();
		this.setOnMouseEntered(m);
		this.setOnMouseExited(m);
		this.setOnMouseClicked(m);
	}
	
	public MediumLevel(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/MediumLevel1.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(200);
		setFitHeight(100);
		MyMouseHandler m = new MyMouseHandler();
		this.setOnMouseEntered(m);
		this.setOnMouseExited(m);
		this.setOnMouseClicked(m);
	}
	
	@Override 
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	private class MyMouseHandler implements EventHandler<MouseEvent> {
		@Override
		public void handle(MouseEvent m) {
			// TODO Auto-generated method stub
			if (m.getEventType().equals(MouseEvent.MOUSE_ENTERED)) {
				String path = getClass().getClassLoader().getResource("images/MediumLevel2.png").toString();
				Image img = new Image(path);
				setImage(img);
				setFitWidth(200);
				setFitHeight(100);
			} else if (m.getEventType().equals(MouseEvent.MOUSE_EXITED)) {
				String path = getClass().getClassLoader().getResource("images/MediumLevel1.png").toString();
				Image img = new Image(path);
				setImage(img);
				setFitWidth(200);
				setFitHeight(100);
			} else if (m.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
				Floor f = new Floor();
				f.setX(0);
				f.setY(450);
				for (Coin c : getWorld().getObjects(Coin.class)) {
					getWorld().remove(c);
				}
				int[][] grid = {
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1,10, 0, 0, 0, 0,11, 0, 0,11, 0, 0, 0, 0, 0, 0,10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,10, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 7, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 1, 1, 1, 1,11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,11, 2, 2,11, 0, 0, 0, 0, 0, 0, 7, 1, 1, 1, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,11,11,11, 0, 4, 0, 3, 0, 4, 0, 3, 0, 4, 0, 3, 0, 4, 0, 3, 0, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,99, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,11,11,11, 0, 0, 0, 0, 0, 0,11, 0, 0, 0,11, 0, 0, 0,11, 0, 0, 0,11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,11, 2, 2,11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 5, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 2, 2, 0, 0, 0, 0, 0, 0},
						};
				End e = new End(50 * (grid[0].length + 2), 0);
				Level l = new Level(e, true);
				getWorld().add(l);
				getWorld().add(e);
				l.setGrid(grid);
				Player player = new Player(50, 300);
				getWorld().add(player);
				ProgressBar bar = new ProgressBar(225, 25);
				getWorld().add(bar);
				for (Portal p : getWorld().getObjects(Portal.class)) {
					PortalTop pt = new PortalTop((int)p.getX(), (int)p.getY());
					getWorld().add(pt);
				}
				getWorld().add(f);
				((GameWorld)getWorld()).setLevel("medium");
				((GameWorld)getWorld()).removeMenu();
			}
		}
		
	}
}
