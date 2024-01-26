package Entity;

import javafx.scene.image.Image;

public class RSpike extends Item implements ToggleAble{
	private static final String picture1="file:res/RSpike1.png";
	private static final String picture2="file:res/RSpike2.png";
	private boolean isToggled;
	
	public RSpike(int n) {
		super();
		if(n==1) {
			this.setImage(new Image(picture2));
			setToggled(false);
		}
		else {
			this.setImage(new Image(picture1));
			setToggled(true);
		}
		
	}
	public void attack() {
		
	}
	
	public void toggle() {
		if(isToggled()) {
			this.setImage(new Image(picture2));
			setToggled(false);
		}
		else {
			this.setImage(new Image(picture1));
			setToggled(true);
		}
		
	}
	public boolean isToggled() {
		return isToggled;
	}
	public void setToggled(boolean toggled) {
		this.isToggled = toggled;
	}
}