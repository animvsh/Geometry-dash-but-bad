import engine.Actor;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Playbutton extends Actor {

	public Playbutton() {
		String path = getClass().getClassLoader().getResource("images/resume.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(100);
		setFitHeight(100);
		setOnMouseClicked(new MyMouseHandler());
	}
	
	public Playbutton(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/resume.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(100);
		setFitHeight(100);
		setOnMouseClicked(new MyMouseHandler());
	}
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	private class MyMouseHandler implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub
			((GameWorld)getWorld()).resume();
		}
		
	}

}
