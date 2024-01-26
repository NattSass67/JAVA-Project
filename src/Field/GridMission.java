package Field;

import java.util.ArrayList;

import Character.Player;
import Entity.Item;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

public class GridMission extends GridPane{
	private static final String picture1="file:res/floor.png";
	private ObjectField field;
	
	public GridMission(ObjectField field) {//เลือกด่าน
		this.field=field;
		generateMission(field.getSizeX()); //Its okay cuz its square
		this.setPadding(new Insets(5));
		this.setHgap(5);
		this.setVgap(5);
		this.setWidth(690);
		this.setHeight(690);
	};
	
	private void generateMission(int size) {
		// TODO Auto-generated method stub
		//read from data.txt
		this.setBorder(getBorder());
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				VBox box= new VBox();
				BackgroundFill background_fill = new BackgroundFill(Color.DARKGRAY,CornerRadii.EMPTY, Insets.EMPTY);
				Background background = new Background(background_fill);
				box.setBackground(background);
				box.setMaxSize(64,64);
				box.setMinSize(64, 64);
				box.setPrefSize(64, 64);
				ImageView picture = new ImageView(new Image(picture1));
				box.getChildren().add(picture);
				this.add(box, j, i);
			}
		}
		
	}

	

}
