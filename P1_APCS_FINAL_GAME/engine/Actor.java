package engine;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.Pane;

public abstract class Actor extends javafx.scene.image.ImageView {
	public Actor() {
		
	}
	
	public Actor(int x, int y) {
		setX(x);
		setY(y);
	}
	
	public abstract void act(long now);
	
	public double getHeight() {
		return getBoundsInParent().getHeight();
	}
	
	public void move(double dx, double dy) {
		super.setX(dx + super.getX());
		super.setY(dy + super.getY());
	}
	
	public World getWorld() {
		Pane parent = (Pane)getParent();
		if (parent != null && World.class.isAssignableFrom(parent.getClass())) {
			return (World)parent;
		} else {
			return null;
		}
	}
	
	public void addedToWorld() {
		
	}
	
	public double getWidth() {
		return getBoundsInParent().getWidth();
	}
	
	public <A extends Actor>java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls) {
		List<Actor> list = getWorld().getObjects(Actor.class);
		ArrayList<A> intersects = new ArrayList<A>();
		for (int i = 0; i < list.size(); i++) {
			Actor a = list.get(i);
			if (!(a == this)) {
				if (cls.isAssignableFrom(a.getClass())) {
					if (a.intersects(getX(), getY(), getWidth(), getHeight())) {
						intersects.add((A) a);
						
					}
				}
			}
		}
		return intersects;
	}
	
	public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
		List<Actor> list = getWorld().getObjects(Actor.class);
		A intersects;
		for (Actor a : list) {
			if (!(a == this)) {
				if (cls.isAssignableFrom(a.getClass())) {
					if (a.intersects(getX(), getY(), getWidth(), getHeight())) {
						intersects = (A)(a);
						return intersects;
					}
				}
			}
		}
		return null;
	}
}

