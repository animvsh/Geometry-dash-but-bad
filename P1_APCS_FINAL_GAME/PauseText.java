import engine.Actor;
import javafx.scene.image.Image;

public class PauseText extends Actor {

		public PauseText() {
			String path = getClass().getClassLoader().getResource("images/menu_text.png").toString();
			Image img = new Image(path);
			setImage(img);
			setFitWidth(200);
			setFitHeight(100);
		}
		
		public PauseText(int x, int y) {
			super(x, y);
			String path = getClass().getClassLoader().getResource("images/menu_text.png").toString();
			Image img = new Image(path);
			setImage(img);
			setFitWidth(200);
			setFitHeight(100);
		}
		
		@Override
		public void act(long now) {
			// TODO Auto-generated method stub
			
		}
}
