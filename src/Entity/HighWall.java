package Entity;

import javafx.scene.image.Image;

public class HighWall extends Item {
	private static final String picture="file:res/highWall.png";
	public HighWall() {
		super();
		this.setImage(new Image(picture));
	}
}


