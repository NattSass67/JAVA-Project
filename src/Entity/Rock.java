package Entity;

import Control.AudioEffect;
import javafx.scene.image.Image;

public class Rock extends Item implements Movable{
	private static final String picture="file:res/stone.png";
	public Rock() {
		this.setImage(new Image(picture));
		
	}
	public void move(int x,int y) {
		AudioEffect.setAudio("stone");
		try {
			for(int i=0;i<69;i++) {
				Thread.sleep(10);
				this.setX(this.getPosX()+x*i);
				this.setY(this.getPosY()+y*i);
				}
		}
		catch(Exception e) {
			
		}
//		this.setX(this.getPosX()+x*69);
//		this.setY(this.getPosY()+y*69);
		this.setPosX(this.getPosX()+x*69);
		this.setPosY(this.getPosY()+y*69);
		this.setAtCol(this.getAtCol()+x);
		this.setAtRow(this.getAtRow()+y);
		
		
		
	}
//	public void spawn() {
//		this.setImage(new Image(picture));
//
//	}
}
