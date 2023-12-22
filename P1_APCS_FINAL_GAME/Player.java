import engine.Actor;
import engine.World;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class Player extends Actor{
	private double dy = 0;
	private double dx = 0;
	private boolean isJumping = false;
	private boolean run;
	private boolean isShip = false;
	private boolean gotCoin = false;
	
	public Player() {
		String path = getClass().getClassLoader().getResource("images/player.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(49);
	}
	
	public Player(int x, int y) {
		super(x, y);
		String path = getClass().getClassLoader().getResource("images/player.png").toString();
		Image img = new Image(path);
		setImage(img);
		setFitWidth(50);
		setFitHeight(49);
	}
	
	public void setDY(double i) {
		dy = i;
	}
	public void setDX(double i) {
		dx = i;
	}
	public double getDY() {
		return dy;
	}
	public double getV() {
		return dx;
	}

	public double getPercentage() {
		Level l = getWorld().getObjects(Level.class).get(0);
		End e = getWorld().getObjects(End.class).get(0);
		return 1-((e.getX()-getX())/l.getLevelLength());
	}
	
	@Override
	public void act(long now) {
		PortalTop pt = getOneIntersectingObject(PortalTop.class);
		End ee = getWorld().getObjects(End.class).get(0);
		End e = getOneIntersectingObject(End.class);
		
		double rotate = getRotate();
		setRotate(0);
		
		move(dx, -dy);
		
		if (ee != null) {
			if (ee.getX() <= getWorld().getWidth()-50) {
				dx = 8;
			} else {
				dx = 0;
			}
		}
		
		if (e != null) {
			GameWorld world = (GameWorld)getWorld();
			world.finishedLevel(gotCoin);
			world.gameWon(gotCoin);
			return;
		}
		
		if (!isShip) {
			dy -= 1.5;
		}
		
		Coin c = getOneIntersectingObject(Coin.class);
		if (c != null) {
			gotCoin = true;
			c.removeCoin();
		}
		
		if (!isShip && !getWorld().getObjectsAt(getX(), getY(), Platform.class).isEmpty()) {
			GameWorld world = (GameWorld)getWorld();
			//world.remove(this);
			setY(300);
			setX(50);
			world.gameOver();
			return;
		}
		
		Spike d = getOneIntersectingObject(Spike.class);
		Platform p = getOneIntersectingObject(Platform.class);
		JumpPad j = getOneIntersectingObject(JumpPad.class);
		Roof r = getOneIntersectingObject(Roof.class);
		if (d != null && hitSpike(d)) {
			GameWorld world = (GameWorld)getWorld();
			//world.remove(this);
			world.gameOver();
			return;
		} else {
			if (p != null) {
				if (isShip) {
					if (dy > 0 && getX()+getWidth()*7/8 < p.getX() && getY() <= p.getY()+p.getHeight()) {
						GameWorld world = (GameWorld)getWorld();
						//world.remove(this);
						world.gameOver();
						return;
					} else if (dy < 0 && getX()+getWidth()*7/8 < p.getX() && getY()+getHeight() >= p.getY()) {
						GameWorld world = (GameWorld)getWorld();
						//world.remove(this);
						world.gameOver();
						return;
					} else if (dy == 0 && getX()+getWidth()*7/8 < p.getX()) {
						GameWorld world = (GameWorld)getWorld();
						//world.remove(this);
						world.gameOver();
						return;
					} else {
						if (getY()+getHeight() < p.getY()+16) {
							setY(p.getY() - getHeight());
						} else if (getY() >= p.getY()+p.getHeight()-16) {
							setY(p.getY() + p.getHeight());
						}
						dy = 0;
					}
				} else {
					if (getX()+getWidth()*7/8 < p.getX() && getY()+getHeight() >= p.getY()) {
						GameWorld world = (GameWorld)getWorld();
						//world.remove(this);
						world.gameOver();
						return;
					} else {
						setY(p.getY() - getHeight());
						dy = 0;
					}
				}
			}
			if (r != null) {
				if (isShip) {
					if (dy > 0 && getX()+getWidth()*7/8 < r.getX() && getY() <= r.getY()+r.getHeight()) {
						GameWorld world = (GameWorld)getWorld();
						//world.remove(this);
						world.gameOver();
						return;
					} else if (dy < 0 && getX()+getWidth()*7/8 < r.getX() && getY()+getHeight() >= r.getY()) {
						GameWorld world = (GameWorld)getWorld();
						//world.remove(this);
						world.gameOver();
						return;
					} else if (dy == 0 && getX()+getWidth()*7/8 < r.getX()) {
						GameWorld world = (GameWorld)getWorld();
						//world.remove(this);
						world.gameOver();
						return;
					} else {
						if (getY()+getHeight() < r.getY()+16) {
							setY(r.getY() - getHeight());
						} else if (getY() >= r.getY()+r.getHeight()-16) {
							setY(r.getY() + r.getHeight());
						}
						dy = 0;
					}
				} else {
					if (getX()+getWidth()*7/8 < r.getX() && getY()+getHeight() >= r.getY()) {
						GameWorld world = (GameWorld)getWorld();
						//world.remove(this);
						world.gameOver();
						return;
					} else {
						setY(r.getY() - getHeight());
						dy = 0;
					}
				}
			}
			
			World w = getWorld();

			Floor f = getOneIntersectingObject(Floor.class);
			if (f != null) {
				setY(f.getY() - getHeight());
				dy = 0;
			}
//			if (r != null) {
//				setY(r.getY()-getHeight());
//				dy = 0;
//			}
			
			if (pt != null && !pt.isUsed()) {
				String path;
				if (!isShip) {
					path = getClass().getClassLoader().getResource("images/Ship.png").toString();
					Image img = new Image(path);
					setImage(img);
					setFitWidth(70);
					setFitHeight(49);
					isShip = true;
				} else {
					path = getClass().getClassLoader().getResource("images/player.png").toString();
					Image img = new Image(path);
					setImage(img);
					setFitWidth(50);
					setFitHeight(49);
					isShip = false;
				}
				PortalTop temp = new PortalTop((int)pt.getX(), (int)pt.getY());
				getWorld().remove(pt);
				temp.use();
				getWorld().add(temp);
			}
			
			if (!w.getObjectsAt(getX(), getY() + getHeight() + 1, Platform.class).isEmpty() || !w.getObjectsAt(getX(), getY() + getHeight() + 1, Floor.class).isEmpty() || !w.getObjectsAt(getX(), getY() + getHeight() + 1, Roof.class).isEmpty()){
				isJumping = false;
				if (rotate >= 315 || rotate < 45) {
					rotate = -10;
				}  else if (rotate < 135) {
					rotate = 80;
				} else if (rotate < 225) {
					rotate = 170;
				} else {
					rotate = 260;
				}
			} else {
				isJumping = true;
			}
			
			if(getWorld().isKeyPressed(KeyCode.SPACE)) {
				if (!isShip && !isJumping) {
					dy = 20;
					isJumping = true;
					
				} else if (isShip) {
					if (dy <= 15) {
						dy += 0.75;
					}
				}
			} else if (isShip) {
				if (dy >= -15) {
					dy -= 0.75;
				}
			}
			if (j != null) {
				dy = 28;
			}
		}
		if (!isShip) {
			setRotate(rotate + 10);
		} else {
			setRotate(-dy*3);
		}
	}
	
	public boolean hitSpike(Spike s) {
		//y <= 50
		//y <= 2x-50
		//y >= -2x+50
		//System.out.println("Player: ("+getWidth()+", "+getHeight()+")");
		
		double playerX = getX();
		double playerY = getY()-5;
		double spikeX = s.getX();
		double spikeY = s.getY();
		//System.out.println("Player: ("+playerX+", "+playerY+")\nSpike: ("+spikeX+", "+spikeY+")");
		if (s.getRotate() == 0) {
			if (playerY-spikeY <= 50 && playerY-spikeY >= 2*(playerX-spikeX)-50 && playerY-spikeY >= -2*(playerX-spikeX)+50) {
				return true;
			}
			playerX += getWidth();
			if (playerY-spikeY <= 50 && playerY-spikeY >= 2*(playerX-spikeX)-50 && playerY-spikeY >= -2*(playerX-spikeX)+50) {
				return true;
			}
			playerY += getHeight();
			if (playerY-spikeY <= 50 && playerY-spikeY >= 2*(playerX-spikeX)-50 && playerY-spikeY >= -2*(playerX-spikeX)+50) {
				return true;
			}
			playerX -= getWidth();
			if (playerY-spikeY <= 50 && playerY-spikeY >= 2*(playerX-spikeX)-50 && playerY-spikeY >= -2*(playerX-spikeX)+50) {
				return true;
			}
		} else if (s.getRotate() == 90) {
			if (playerX-spikeX >= 0 && playerY-spikeY >= 0.5*(playerX-spikeX) && playerY-spikeY <= -0.5*(playerX-spikeX)+50) {
				return true;
			}
			playerX += getWidth();
			if (playerX-spikeX >= 0 && playerY-spikeY >= 0.5*(playerX-spikeX) && playerY-spikeY <= -0.5*(playerX-spikeX)+50) {
				return true;
			}
			playerY += getHeight();
			if (playerX-spikeX >= 0 && playerY-spikeY >= 0.5*(playerX-spikeX) && playerY-spikeY <= -0.5*(playerX-spikeX)+50) {
				return true;
			}
			playerX -= getWidth();
			if (playerX-spikeX >= 0 && playerY-spikeY >= 0.5*(playerX-spikeX) && playerY-spikeY <= -0.5*(playerX-spikeX)+50) {
				return true;
			}
		} else if (s.getRotate() == 180) {
			if (playerY-spikeY >= 0 && playerY-spikeY <= 2*(playerX-spikeX) && playerY-spikeY <= -2*(playerX-spikeX)+100) {
				return true;
			}
			playerX += getWidth();
			if (playerY-spikeY >= 0 && playerY-spikeY <= 2*(playerX-spikeX) && playerY-spikeY <= -2*(playerX-spikeX)+100) {
				return true;
			}
			playerY += getHeight();
			if (playerY-spikeY >= 0 && playerY-spikeY <= 2*(playerX-spikeX) && playerY-spikeY <= -2*(playerX-spikeX)+100) {
				return true;
			}
			playerX -= getWidth();
			if (playerY-spikeY >= 0 && playerY-spikeY <= 2*(playerX-spikeX) && playerY-spikeY <= -2*(playerX-spikeX)+100) {
				return true;
			}
		} else if (s.getRotate() == 270) {
			if (playerX-spikeX <= 50 && playerY-spikeY >= -0.5*(playerX-spikeX)+25 && playerY-spikeY <= 0.5*(playerX-spikeX)+25) {
				return true;
			}
			playerX += getWidth();
			if (playerX-spikeX <= 50 && playerY-spikeY >= -0.5*(playerX-spikeX)+25 && playerY-spikeY <= 0.5*(playerX-spikeX)+25) {
				return true;
			}
			playerY += getHeight();
			if (playerX-spikeX <= 50 && playerY-spikeY >= -0.5*(playerX-spikeX)+25 && playerY-spikeY <= 0.5*(playerX-spikeX)+25) {
				return true;
			}
			playerX -= getWidth();
			if (playerX-spikeX <= 50 && playerY-spikeY >= -0.5*(playerX-spikeX)+25 && playerY-spikeY <= 0.5*(playerX-spikeX)+25) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isGameOver() {
		return run;
	}
	
	public void setGameOver(){
		run = false;
	}
	
	public double calcDistance(Actor a) {
		return Math.sqrt(Math.pow(getX()-a.getX(), 2)+Math.pow(getY()+a.getY(), 2));
	}
	
	public void jump() {
		if (!isShip) {
			PurpleOrb po = getOneIntersectingObject(PurpleOrb.class);
			Orb o = getOneIntersectingObject(Orb.class);
			if (po != null && o != null) {
				if (calcDistance(po) > calcDistance(o)) {
					dy = 20;
					isJumping = true;
					//System.out.println("1");
				} else {
					dy = 10;
					isJumping = true;
					//System.out.println("2");
				}
			} else if (po != null) {
				dy = 10;
				isJumping = true;
				//System.out.println("3");
			} else {
				dy = 20;
				//setY(50);
				isJumping = true;
				//System.out.println("4");
			}
		}
	}
	
	public boolean isJumping() {
		return isJumping;
	}
	
	public void setGamemode(boolean b) {
		isShip = b;
	}
	

//    private class KeyListener implements EventHandler<KeyEvent>{
//
//		@Override
//		public void handle(KeyEvent e) {
//			if (e.getCode() == KeyCode.SPACE) {
//				Orb o = getOneIntersectingObject(Orb.class);
//				if (o != null) {
//					dy = 20;
//					isJumping = true;
//				}
//			}
//			
//		}
//    	
//    }
	 
}