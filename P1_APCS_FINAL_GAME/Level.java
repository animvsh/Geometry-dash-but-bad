import java.util.List;

import engine.*;

public class Level extends Actor {
	private Actor[][] map; //each grid is 50x50
	private World world;
	private End e;
	private int deleteCol;
	private int mapTickPassed;
	private double eLength;
	private int coinX, coinY;
	private boolean coin;

	public Level(End e, boolean hasCoin) {
		map = null;
		world = getWorld();
		this.e = e;
		deleteCol = 0;
		mapTickPassed = 0;
		coin = hasCoin;
	}
	
	public double getLevelLength() {
		return (map[0].length*50)+100;
	}
	
	public void resetLevel() {
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				if (map[row][col] != null) {
					if (map[row][col].getClass() == Portal.class) {
						PortalTop p = map[row][col].getOneIntersectingObject(PortalTop.class);
						p.setX(col*50);
						p.setY(row*50);
					}
					if (map[row][col].getClass() == JumpPad.class) {
						map[row][col].setX(col*50);
						map[row][col].setY(row*50+40);
					} else {
						map[row][col].setX(col*50);
						map[row][col].setY(row*50);
					}
				//System.out.println("X:"+col*50+", Y:"+row*50);
				}
			}
		}
		if (coin && getWorld().getObjects(Coin.class).size() == 0) {
			Coin c = new Coin(coinX*50, coinY*50);
			map[coinX][coinY] = c;
			world.add(c);
		}
		e.setX(50*(map[0].length+2));
		//System.out.println();
	}
	
	public void setGrid(int[][] grid) {
		world = getWorld();
		eLength = e.getX();
		map = new Actor[grid.length][grid[0].length];
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == 0) {
					map[row][col] = null;
				} else if (grid[row][col] == 1) {
					map[row][col] = new Block(col*50, row*50);
					world.add(map[row][col]);
				} else if (grid[row][col] == 2) {
					map[row][col] = new Platform(col*50, row*50);
					world.add(map[row][col]);
				} else if (grid[row][col] == 3) {
					map[row][col] = new Spike(col*50, row*50);
					world.add(map[row][col]);
				} else if (grid[row][col] == 4) {
					map[row][col] = new Orb(col*50, row*50);
					world.add(map[row][col]);
				} else if (grid[row][col] == 5) {
					map[row][col] = new JumpPad(col*50, row*50+40);
					world.add(map[row][col]);
				} else if (grid[row][col] == 6) {
					map[row][col] = new Spike(col*50, row*50);
					map[row][col].setRotate(90);
					world.add(map[row][col]);
				} else if (grid[row][col] == 7) {
					map[row][col] = new Spike(col*50, row*50);
					map[row][col].setRotate(180);
					world.add(map[row][col]);
				} else if (grid[row][col] == 8) {
					map[row][col] = new Spike(col*50, row*50);
					map[row][col].setRotate(270);
					world.add(map[row][col]);
				} else if (grid[row][col] == 9) {
					map[row][col] = new Portal(col*50, row*50);
					world.add(map[row][col]);
				} else if (grid[row][col] == 10) {
					map[row][col] = new Roof(col*50, row*50);
					world.add(map[row][col]);
				} else if (grid[row][col] == 11) {
					map[row][col] = new Stack(col*50, row*50);
					world.add(map[row][col]);
				} else if (grid[row][col] == 12) {
					map[row][col] = new PurpleOrb(col*50, row*50);
					world.add(map[row][col]);
				} else if (grid[row][col] == 99) {
					map[row][col] = new Coin(col*50, row*50);
					world.add(map[row][col]);
					if (coin) {
						coinX = col;
						coinY = row;
					}
				}
			}
		}
	}

	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
//		if (eLength-e.getX() > mapTickPassed*50) {
//			mapTickPassed++;
//			if (mapTickPassed >= 2) {
//				for (int row = 0; row < map.length; row++) {
//					if (map[row][deleteCol] != null) {
//						if (map[row][deleteCol].getClass().isAssignableFrom(Portal.class)) {
//						} else if (map[row][deleteCol].getClass().isAssignableFrom(PortalTop.class)) {
//						} else if (map[row][deleteCol].getClass().isAssignableFrom(Roof.class)) {
//						} else {
//							world.remove(map[row][deleteCol]);
//							map[row][deleteCol] = null;
//						}
//					}
//				}
//				deleteCol++;
//			}
//		}
		if (map != null && e != null && e.getX() > getWorld().getWidth()-50) {
			for (int row = 0; row < map.length; row++) {
				for (int col = 0; col < map[0].length; col++) {
					if (map[row][col] != null) {
						if (map[row][col].getClass().isAssignableFrom(Portal.class)) {
							((Portal)map[row][col]).shiftToTheLeft(8);
						} else {
							map[row][col].setX(map[row][col].getX() - 8);
						}
					}
				}
			}
			e.setX(e.getX() - 8);
		} else if (!(e.getX() > getWorld().getWidth()-50)) {
			e.setX(getWorld().getWidth()-50);
		}
	}
}