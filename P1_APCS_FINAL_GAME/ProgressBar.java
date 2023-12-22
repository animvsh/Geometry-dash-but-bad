import engine.*;
import javafx.scene.image.Image;

public class ProgressBar extends Actor {
	
	private int percent;
	private Progress progress;
	
	public ProgressBar() {
		String path = getClass().getClassLoader().getResource("images/bar.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(300);
		setFitHeight(30);
		percent = 0;
	}
	
	public ProgressBar(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/bar.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(300);
		setFitHeight(30);
		percent = 0;
	}
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if (progress == null && getWorld() != null) {
			progress = new Progress((int)getX(), (int)getY()+2);
			getWorld().add(progress);
		}
		Player p = getWorld().getObjects(Player.class).get(0);
		if (Math.floor(p.getPercentage()*100) != percent) {
			percent = (int)Math.floor(p.getPercentage()*100);
			progress.setFitWidth(percent*3);
		}
	}

}