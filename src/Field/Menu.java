package Field;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Menu extends Pane{
	
	public static ImageView start;
	public static ImageView Options;
	public static ImageView Quit;
	
	public Menu() {
		
		ImageView Im = new ImageView(new Image("file:res/menu01.jpg"));
		Im.setPreserveRatio(true);
//		Im.setFitWidth(100);
		Im.setFitHeight(700);
		
		this.getChildren().add(Im);
		
		ImageView B1 = new ImageView(new Image("file:res/plat.png"));
		B1.setPreserveRatio(true);
		B1.setFitWidth(600);
		this.getChildren().add(B1);
		B1.setX(395);
		B1.setY(120);
		
		start = new ImageView(new Image("file:res/Start.png"));
		start.setPreserveRatio(true);
		start.setFitWidth(300);
		this.getChildren().add(start);
		start.setX(535);
		start.setY(220);
//		start.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//			@Override
//			public void handle(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
		
		Quit = new ImageView(new Image("file:res/Quit.png"));
		Quit.setPreserveRatio(true);
		Quit.setFitWidth(281);
		this.getChildren().add(Quit);
		Quit.setX(535);
		Quit.setY(420);
		
		Options = new ImageView(new Image("file:res/Options.png"));
		Options.setPreserveRatio(true);
		Options.setFitWidth(315);
		this.getChildren().add(Options);
		Options.setX(528);
		Options.setY(320);
		
	}
	
	

}