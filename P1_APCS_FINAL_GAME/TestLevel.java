import engine.*;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class TestLevel extends Actor {

	public TestLevel() {
		String path = getClass().getClassLoader().getResource("images/HardLevel1.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(200);
		setFitHeight(100);
		MyMouseHandler m = new MyMouseHandler();
		this.setOnMouseEntered(m);
		this.setOnMouseExited(m);
		this.setOnMouseClicked(m);
	}
	
	public TestLevel(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/HardLevel1.png").toString();
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
				String path = getClass().getClassLoader().getResource("images/HardLevel2.png").toString();
				Image img = new Image(path);
				setImage(img);
				setFitWidth(200);
				setFitHeight(100);
			} else if (m.getEventType().equals(MouseEvent.MOUSE_EXITED)) {
				String path = getClass().getClassLoader().getResource("images/HardLevel1.png").toString();
				Image img = new Image(path);
				setImage(img);
				setFitWidth(200);
				setFitHeight(100);
			} else if (m.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
				Floor f = new Floor();
				getWorld().add(f);
				f.setX(0);
				f.setY(450);
				for (Coin c : getWorld().getObjects(Coin.class)) {
					getWorld().remove(c);
				}
				int[][] grid = {
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0,12,12,12,12,12,12,12,12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3}
				};
				
//				int[][] grid = {
//						{4, 0, 0, 0, 4, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 3, 3, 3, 0, 0, 0, 3, 3, 3, 0, 0, 0,99},
//						{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
//						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//						{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//						{0, 0, 0, 0, 0, 0, 1, 1, 0, 4, 0, 3, 0, 4, 0, 3, 0, 4, 0, 3, 0, 4, 0, 3, 0, 4, 4, 0},
//						{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//						{0, 0, 0, 0, 5, 0, 1, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0, 3, 0}
//						};
				End e = new End(50 * (grid[0].length + 2), 0);
				Level l = new Level(e, false);
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
				((GameWorld)getWorld()).setLevel("hard");
				((GameWorld)getWorld()).removeMenu();
			}
		}
	}
}
