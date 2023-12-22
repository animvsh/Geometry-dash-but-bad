import engine.Actor;
import javafx.scene.image.Image;

public class Coin extends Actor {
	private int startRemove;
	private boolean removeCoin;

	public Coin() {
		String path = getClass().getClassLoader().getResource("images/coin.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(100);
		setFitHeight(100);
		startRemove = 0;
		removeCoin = false;
	}
	
	public Coin(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/coin.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(100);
		setFitHeight(100);
		startRemove = 0;
		removeCoin = false;
	}
	
	public void removeCoin() {
		removeCoin = true;
	}
	
	@Override
	public void act(long now) {
//		setX(getX()- 3);
		if (removeCoin) {
			startRemove++;
			setY(getY()-5);
			if (startRemove >= 5) {
				getWorld().remove(this);
			}
		}
	}
}
