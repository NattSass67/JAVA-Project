package Field;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Controller extends Pane{
	
	public static ImageView back;
	public static ImageView next;
	
	public Controller() {
		ImageView Im = new ImageView(new Image("file:res/menu01.jpg"));
		Im.setPreserveRatio(true);
		Im.setFitHeight(700);
		this.getChildren().add(Im);
		
		ImageView controller = new ImageView(new Image("file:res/Controller.png"));
		controller.setPreserveRatio(true);
		controller.setFitWidth(600);
		this.getChildren().add(controller);
		controller.setX(395);
		controller.setY(120);
		
		next = new ImageView(new Image("file:res/Next.png"));
		next.setPreserveRatio(true);
		next.setFitWidth(80);
		this.getChildren().add(next);
		next.setX(820);
		next.setY(460);
		
		back = new ImageView(new Image("file:res/Back.png"));
		back.setPreserveRatio(true);
		back.setFitWidth(80);
		this.getChildren().add(back);
		back.setX(460);
		back.setY(460);
	}
}
