import engine.Actor;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class WinScreen extends Actor {
	
	public WinScreen() {
		String path = getClass().getClassLoader().getResource("images/Spike.png").toString();
		//String path = getClass().getClassLoader().getResource("images/Spike.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(750);
		setFitHeight(500);
	}
	
	public WinScreen(boolean gotCoin) {
		String path;
		if (!gotCoin) {
			//We need an image for this
			path = getClass().getClassLoader().getResource("images/winWithoutCoinScreen.png").toString();
//			System.out.println("Congrats, you beat the level... but can you get the Coin?");
		} else  {
			//We need an image for this
			path = getClass().getClassLoader().getResource("images/winWithCoinScreen.png").toString();
//			System.out.println("Wow you got the coin!!!!");
		}
		//String path = getClass().getClassLoader().getResource("images/Spike.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(750);
		setFitHeight(500);
	}
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		if (getWorld().isKeyPressed(KeyCode.ENTER)) {
			GameWorld w = (GameWorld)getWorld();
			w.menuScreen();
		}
	}
}
