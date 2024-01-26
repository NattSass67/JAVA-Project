package Entity;

import javafx.scene.image.Image;

public class Posion extends Item implements ToggleAble {
	private static final String picture="file:res/Posion.png";
	private static final String picture1="file:res/Posion2.png";
	private boolean isToggled;
	private boolean isAnimate;
	private int restore;
	
	public Posion(int n) {
		super();
		restore=n;
		this.setImage(new Image(picture));///this.setImage(null)
		setAnimate(true);
		
	}
	public void toggle() {
		if(isAnimate()) {
			if(isToggled()) {
				this.setImage(new Image(picture));
				setToggled(false);
			}
			else {
				this.setImage(new Image(picture1));
				setToggled(true);
			}
		}
		
	}
	public boolean isToggled() {
		return isToggled;
	}
	public void setToggled(boolean toggled) {
		this.isToggled = toggled;
	}
	public boolean isAnimate() {
		return isAnimate;
	}
	public void setAnimate(boolean animate) {
		this.isAnimate = animate;
	}
//	public void spawn() {
//		this.setImage(new Image(picture));///this.setImage(null)
//		setAnimate(true);
//	}
	public int getRestore() {
		return restore;
	}
}
