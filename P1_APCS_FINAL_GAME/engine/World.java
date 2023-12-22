package engine;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public abstract class World extends javafx.scene.layout.Pane {
    protected ArrayList<Actor> actorList = new ArrayList<>();
    protected MyAnimationTimer timer;
    protected boolean isTimerRunning;
    protected Set<KeyCode> keySet;
    protected boolean widthSet;
    protected boolean heightSet;
    protected boolean dimensionSet;

    public World() {
        timer = new MyAnimationTimer();
        widthSet = false;
        heightSet = false;
        dimensionSet = false;
        keySet = new HashSet<>();
        isTimerRunning = false;
        widthProperty().addListener(new WidthListener());
        heightProperty().addListener(new HeightListener());
        sceneProperty().addListener(new SceneListener());
        setOnKeyPressed(new KeyListener());
        setOnKeyReleased(new KeyListener2());
        		
    }

    public void add(Actor a) {
        actorList.add(a);
        getChildren().add(a);
        a.addedToWorld();
    }

    public void remove(Actor a) {
        actorList.remove(a);
        getChildren().remove(a);
    }

    public abstract void act(long now);

    public void start() {
        timer.start();
        isTimerRunning = true;
    }
    
    public void stop() {
        timer.stop();
        isTimerRunning = false;
    }
    

    public boolean isStopped() {
    	return !isTimerRunning;
    }
    
    public boolean isKeyPressed(KeyCode code) {
    	return keySet.contains(code);
    }
    
    public <A extends Actor> java.util.List<A> getObjects(Class<A> class1){
        ArrayList<A> a = new ArrayList<A>();
        for (int i = 0; i < actorList.size(); i++) {
            if (class1.isInstance(actorList.get(i))) {
                a.add((A)(actorList.get(i)));
            }
        }
        return a;
    }
    
    public <A extends Actor> java.util.List<A> getObjectsAt(double x,double y, java.lang.Class<A> cls) {
    	List<A> list = getObjects(cls);
    	ArrayList<A> a = new ArrayList<A>();
    	for (int i = 0; i < list.size(); i++) {
    		A temp = list.get(i);
    		if (x >= temp.getX() && x <= (temp.getX() + temp.getWidth()) && y >= temp.getY() && y <= (temp.getY() + temp.getHeight())) {
    			a.add(temp);
    		}
    	}
    	return a;
    }

    protected class MyAnimationTimer extends AnimationTimer {
    	double tick = 1e8;
    	double seconds = 0;
    	
        public MyAnimationTimer() {
            super();
        }

        @Override
        public void handle(long arg0) {
            // TODO Auto-generated method stub
        	if (arg0-seconds*tick >= tick) {
        		seconds++;
        		act(arg0);
        		for (int i = 0; i < actorList.size(); i++) {
        			Actor a = actorList.get(i);
        			a.act(arg0);
        			if (!actorList.contains(a)) {
        				i--;
        			}
        		}
        	}
        }
    }
    
    private class WidthListener implements ChangeListener<Number>{

		@Override
		public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
			if(getWidth() > 0) {
				widthSet = true;
				if(heightSet && !dimensionSet) {
					onDimensionsInitialized();
					dimensionSet = true;
				}
			}
			
			
		}
    	
    }
    
    private class HeightListener implements ChangeListener<Number>{

		@Override
		public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
			if(getHeight() > 0) {
				heightSet = true;
				if(widthSet && !dimensionSet) {
					onDimensionsInitialized();
					dimensionSet = true;
				}
			}
			
		}
    	
    }
    
    private class SceneListener implements ChangeListener<Scene>{

		@Override
		public void changed(ObservableValue<? extends Scene> arg0, Scene arg1, Scene newVal) {
			if(newVal != null) {
				requestFocus();
			}
			
		}
    	
    }
    
    private class KeyListener implements EventHandler<KeyEvent>{

		@Override
		public void handle(KeyEvent arg0) {
			keySet.add(arg0.getCode());
			
		}
    	
    }
   
    private class KeyListener2 implements EventHandler<KeyEvent>{

		@Override
		public void handle(KeyEvent arg0) {
			while (keySet.contains(arg0.getCode())) {
				keySet.remove(arg0.getCode());
			}
			
		}
    	
    }
    
    

	public abstract void onDimensionsInitialized();
}