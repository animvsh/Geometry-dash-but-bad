

import java.io.File;

import engine.Actor;
import engine.World;
//import engine.World.KeyListener;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class GameWorld extends World {
	private boolean run;
	private boolean isPressed = false;
	private boolean easyFinished;
	private boolean mediumFinished;
	private boolean hardFinished;
	private boolean easyCoin = false;
	private boolean mediumCoin = false;
	private boolean hardCoin = false;
	private String currentLevel;
	private boolean isPaused = false;
	public static boolean isMusicPlaying = false;
	private MediaPlayer mediaPlayer;
	private MediaView m = new MediaView();
	
	//private Player geoPlayer = new Player();
	Player player;
	Level l;

	public GameWorld() {
		super();
		run = true;
		super.start();
		setOnKeyPressed(new MyKeyListener());
		easyFinished = false;
		mediumFinished = false;
		hardFinished = false;
		currentLevel = "";
	}
	
	public GameWorld(int w, int h) {
		super();
		setWidth(w);
		setHeight(h);
		run = true;
		super.start();
		setOnKeyPressed(new MyKeyListener());
		easyFinished = false;
		mediumFinished = false;
		hardFinished = false;
		currentLevel = "";
	}
	
	public void setLevel(String s) {
		currentLevel = s;
	}
	

	
	public void finishedLevel(boolean gotCoin) {
		if (currentLevel.equals("easy")) {
			easyFinished = true;
			if (gotCoin) {
				easyCoin = true;
			}
		} else if (currentLevel.equals("medium")) {
			mediumFinished = true;
			if (gotCoin) {
				mediumCoin = true;
			}
		} else if (currentLevel.equals("hard")) {
			hardFinished = true;
			if (gotCoin) {
				hardCoin = true;
			}
		}
	}
	
	@Override
	public void act(long now) {
		if(super.getObjects(Player.class).size() != 0) {
			player = super.getObjects(Player.class).get(0);
		}
		if (isPressed && !super.keySet.contains(KeyCode.SPACE)) {
			isPressed = false;
		}
		//System.out.println(mediaPlayer.isMute());
		//System.out.println(mediaPlayer.isAutoPlay());
	}

	@Override
	public void onDimensionsInitialized() {
		// TODO Auto-generated method stub
		TitleScreen s = new TitleScreen();
		add(s);
		super.start();
	}
	
	public void gameOver() {
		getObjects(Level.class).get(0).resetLevel();
		player.setX(50);
		player.setY(300);
		player.setGamemode(false);
		//menuScreen();
	}
	
	public void removeAll() {
		if (actorList != null) {
			for (int i = 0; i < actorList.size(); i++) {
				Actor a = actorList.get(i);
    			remove(a);
    			if (!actorList.contains(a)) {
    				i--;
    			}
    		}
		}
	}
	
	public void removeMenu() {
		for (Checkmark c : getObjects(Checkmark.class)) {
			remove(c);
		}
		remove(getObjects(EasyLevel.class).get(0));
		remove(getObjects(MediumLevel.class).get(0));
		remove(getObjects(HardLevel.class).get(0));
		remove(getObjects(TestLevel.class).get(0));
	}
	
	public void menuScreen() {
		run = false;
		if (actorList != null) {
			for (int i = 0; i < actorList.size(); i++) {
				Actor a = actorList.get(i);
    			remove(a);
    			if (!actorList.contains(a)) {
    				i--;
    			}
    		}
		}
		super.stop();
		currentLevel = "";
		Background b = new Background();
		add(b);
		EasyLevel button = new EasyLevel((int)(getWidth()/2-100), (int)(getHeight()/2-150));
		add(button);
		if (easyFinished) {
			Checkmark c = new Checkmark((int)(getWidth()/2+100), (int)(getHeight()/2-150));
			add(c);
		}
		if (easyCoin) {
			Coin c = new Coin((int)(getWidth()/2+200), (int)(getHeight()/2-150));
			add(c);
		}
		MediumLevel button2 = new MediumLevel((int)(getWidth()/2-100), (int)(getHeight()/2-50));
		add(button2);
		if (mediumFinished) {
			Checkmark c = new Checkmark((int)(getWidth()/2+100), (int)(getHeight()/2-50));
			add(c);
		}
		if (mediumCoin) {
			Coin c = new Coin((int)(getWidth()/2+200), (int)(getHeight()/2-50));
			add(c);
		}
		HardLevel button3 = new HardLevel((int)(getWidth()/2-100), (int)(getHeight()/2+50));
		add(button3);
		if (hardFinished) {
			Checkmark c = new Checkmark((int)(getWidth()/2+100), (int)(getHeight()/2+50));
			add(c);
		}
		if (hardCoin) {
			Coin c = new Coin((int)(getWidth()/2+200), (int)(getHeight()/2+50));
			add(c);
		}
		TestLevel t = new TestLevel((int)(getWidth()/2-100), (int)(getHeight()/2+150));
		add(t);
		super.start();
	}
	
	public boolean isGameOver() {
		return run;
	}
	
	 private class MyKeyListener implements EventHandler<KeyEvent>{

			@Override
			public void handle(KeyEvent e) {
				keySet.add(e.getCode());
				
				if (getObjects(Player.class).size() > 0) {
					if (e.getCode() == KeyCode.ESCAPE) {
						timer.stop();
						isPaused = true;
						getObjects(ProgressBar.class).get(0).setY(getHeight() / 3);
						getObjects(Progress.class).get(0).setY(getHeight() / 3+2);
						Playbutton b = new Playbutton();
						b.setX(getWidth() / 2 - b.getWidth() / 2);
						b.setY(getHeight() / 2);
						add(b);
						Menubutton m = new Menubutton();
						m.setX(getWidth() * 2 / 3);
						m.setY(getHeight() / 2);
						add(m);
						PauseText p = new PauseText();
						p.setX(getWidth() / 2 - p.getWidth() / 2);
						p.setY(50);
						add(p);
					}
					
					if (isPaused && e.getCode() == KeyCode.P) {
						resume();
					}
					
					Player p = getObjects(Player.class).get(0);
					if (e.getCode() == KeyCode.SPACE) {
						if (!isPressed) {
//							System.out.println("tyepd");
							if (!p.isJumping()) {
								p.jump();
							} else {
								Orb o = p.getOneIntersectingObject(Orb.class);
								if (o != null) {
									p.jump();
								}
							}
						}
					}
					isPressed = true;
				}
				
			}
	    }

	public void gameWon(boolean gotCoin) {
		// TODO Auto-generated method stub
		run = false;
		if (actorList != null) {
			for (int i = 0; i < actorList.size(); i++) {
				Actor a = actorList.get(i);
    			remove(a);
    			if (!actorList.contains(a)) {
    				i--;
    			}
    		}
		}
		WinScreen w = new WinScreen(gotCoin);
		Checkmark c = new Checkmark(250, 275);
		add(w);
		//add(c);
		if ((currentLevel.equals("easy") && easyCoin) || (currentLevel.equals("medium") && mediumCoin) || (currentLevel.equals("hard") && hardCoin)) {
			Coin yay = new Coin(400, 275);
			//add(yay);
		}
	}

	public void resume() {
		// TODO Auto-generated method stub
		timer.start();
		getObjects(ProgressBar.class).get(0).setY(25);
		getObjects(Progress.class).get(0).setY(27);
		remove(getObjects(Playbutton.class).get(0));
		remove(getObjects(Menubutton.class).get(0));
		remove(getObjects(PauseText.class).get(0));
	}
}
