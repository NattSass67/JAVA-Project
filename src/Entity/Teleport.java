package Entity;

import javafx.scene.image.Image;

public class Teleport extends Item implements ToggleAble{
	private static final String picture1="file:res/Tp1.png";
	private static final String picture2="file:res/Tp2.png";
	private boolean isToggled;
	private boolean isAnimate;
	
	public Teleport() {
		super();
		this.setImage(new Image(picture1));
		setAnimate(true);
		
	}
	public void toggle() {
		if(isAnimate()) {
			if(isToggled()) {
				this.setImage(new Image(picture1));
				setToggled(false);
			}
			else {
				this.setImage(new Image(picture2));
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

}
