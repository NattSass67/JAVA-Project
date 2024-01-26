package Entity;

import Field.ObjectField;
import javafx.application.Platform;
import javafx.scene.image.Image;

public class Box extends Item {
	private static final String picture="file:res/box.png";
	private static final String[] desPic= {"file:res/box0.png","file:res/box1.png","file:res/box2.png","file:res/box3.png"};
	public Box() {
		super();
		this.setImage(new Image(picture));///this.setImage(null)
		
	}

	public void destroy() {
		Thread thread = new Thread(() -> {
		for(int i=0;i<4;i++) {
			this.setImage(new Image(desPic[i]));
			try {
				Thread.sleep(150);	
				}
			catch(Exception e) {
				
			}
		}
		this.setImage(null);
		});
		thread.start();
	}
	public void replace(ObjectField room,int idx,Item ps) {
		Thread thread = new Thread(() -> {
			Platform.runLater(new Runnable(){
				@Override
				public void run() {
					
					}
				});
			for(int i=0;i<4;i++) {
				this.setImage(new Image(desPic[i]));
				try {
					Thread.sleep(150);	
					}
				catch(Exception e) {
					
				}
			}
			this.setImage(null);
			Platform.runLater(new Runnable(){
				@Override
				public void run() {
					room.getChildren().remove(idx);
					room.getChildren().add(idx,ps);
					}
				});
		
			});
			thread.start();
		
	}
	
}
