package Field;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import Character.Player;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
public class Heart extends HBox{
	private ImageView img;
	private Player P;
	private Text text;
	
	public Heart(Player P){
		this.P=P;
		this.setAlignment(Pos.TOP_LEFT);	
		img =new ImageView(new Image("file:res/Heart.png"));
		text=new Text(" \n"+P.getHealth());
		text.setTextAlignment(TextAlignment.CENTER);
		text.setFill(Color.WHITE);
		text.setStyle("-fx-font-size : 30");
		this.getChildren().addAll(img,text);
	}
		
	public void update() {
		text.setText(" \n"+P.getHealth());
	}
}
