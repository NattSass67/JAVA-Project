package Field;

import java.security.PublicKey;

import Control.Audio;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Settings extends Pane{
	
	public static int music = 3;
	public static int sound = 3;
	public static ImageView continues;
	private Image gray = new Image("file:res/Gray.png");
	private Image green = new Image("file:res/Gr.png");
	private ImageView mu1 = new ImageView(gray);
	private ImageView mu2 = new ImageView(gray);
	private ImageView mu3 = new ImageView(gray);
	private ImageView mu4 = new ImageView(gray);
	private ImageView mu5 = new ImageView(gray);
	private ImageView so1 = new ImageView(gray);
	private ImageView so2 = new ImageView(gray);
	private ImageView so3 = new ImageView(gray);
	private ImageView so4 = new ImageView(gray);
	private ImageView so5 = new ImageView(gray);
	
	
	public Settings() {
		
		ImageView Im = new ImageView(new Image("file:res/menu01.jpg"));
		Im.setPreserveRatio(true);
//		Im.setFitWidth(100);
		Im.setFitHeight(700);
		this.getChildren().add(Im);
		
		ImageView pla = new ImageView(new Image("file:res/Setting.png"));
		pla.setPreserveRatio(true);
		pla.setFitWidth(600);
		this.getChildren().add(pla);
		pla.setX(395);
		pla.setY(120);
		
		ImageView musicplus = new ImageView(new Image("file:res/plus.png"));
		musicplus.setPreserveRatio(true);
		musicplus.setFitHeight(100);
		this.getChildren().add(musicplus);
		musicplus.setX(820);
		musicplus.setY(287);
		musicplus.setOnMouseReleased(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				musicup();
				Audio.setVolume(music*0.2);
			}
		});
		
		ImageView musicminus = new ImageView(new Image("file:res/minus.png"));
		musicminus.setPreserveRatio(true);
		musicminus.setFitHeight(100);
		this.getChildren().add(musicminus);
		musicminus.setX(420);
		musicminus.setY(287);
		musicminus.setOnMouseReleased(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				musicdown();
				Audio.setVolume(music*0.2);
			}
		});
		
		ImageView soundplus = new ImageView(new Image("file:res/plus.png"));
		soundplus.setPreserveRatio(true);
		soundplus.setFitHeight(100);
		this.getChildren().add(soundplus);
		soundplus.setX(820);
		soundplus.setY(390);
		soundplus.setOnMouseReleased(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				soundup();
			}
		});
		
		ImageView soundminus = new ImageView(new Image("file:res/minus.png"));
		soundminus.setPreserveRatio(true);
		soundminus.setFitHeight(100);
		this.getChildren().add(soundminus);
		soundminus.setX(420);
		soundminus.setY(390);
		soundminus.setOnMouseReleased(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				sounddown();
			}
			
		});
		
		continues = new ImageView(new Image("file:res/Continue.png"));
		continues.setPreserveRatio(true);
		continues.setFitHeight(100);
		this.getChildren().add(continues);
		continues.setX(600);
		continues.setY(500);
		
		
		mu1.setPreserveRatio(true);
		mu1.setFitWidth(60);
		mu2.setPreserveRatio(true);
		mu2.setFitWidth(60);
		mu3.setPreserveRatio(true);
		mu3.setFitWidth(60);
		mu4.setPreserveRatio(true);
		mu4.setFitWidth(60);
		mu5.setPreserveRatio(true);
		mu5.setFitWidth(60);
		this.getChildren().addAll(mu1,mu2,mu3,mu4,mu5);
		mu1.setX(520);mu1.setY(320);mu2.setX(580);mu2.setY(320);mu3.setX(640);mu3.setY(320);mu4.setX(700);mu4.setY(320);mu5.setX(760);mu5.setY(320);
		

		so1.setPreserveRatio(true);
		so1.setFitWidth(60);
		so2.setPreserveRatio(true);
		so2.setFitWidth(60);
		so3.setPreserveRatio(true);
		so3.setFitWidth(60);
		so4.setPreserveRatio(true);
		so4.setFitWidth(60);
		so5.setPreserveRatio(true);
		so5.setFitWidth(60);
		this.getChildren().addAll(so1,so2,so3,so4,so5);
		so1.setX(520);so1.setY(422);so2.setX(580);so2.setY(422);so3.setX(640);so3.setY(422);so4.setX(700);so4.setY(422);so5.setX(760);so5.setY(422);
		
		update();
		
	}
	
	public void musicup() {
		if (music >= 5) {
			music=5;
		}else {
			music+=1;
		}
		update();		
	}
	public void musicdown() {
		if (music <= 0) {
			music=0;
		}else {
			music-=1;
		}
		update();
	}
	
	public void soundup() {
		if (sound >= 5) {
			sound=5;
		}else {
			sound+=1;
		}
		update();		
	}
	public void sounddown() {
		if (sound <= 0) {
			sound=0;
		}else {
			sound-=1;
		}
		update();
	}
	
	public void update() {
		
		switch(this.music) {
		case 0:
			mu1.setImage(gray);mu2.setImage(gray);mu3.setImage(gray);mu4.setImage(gray);mu5.setImage(gray);break;
		case 1:
			mu1.setImage(green);mu2.setImage(gray);mu3.setImage(gray);mu4.setImage(gray);mu5.setImage(gray);break;
		case 2:
			mu1.setImage(green);mu2.setImage(green);mu3.setImage(gray);mu4.setImage(gray);mu5.setImage(gray);break;
		case 3:
			mu1.setImage(green);mu2.setImage(green);mu3.setImage(green);mu4.setImage(gray);mu5.setImage(gray);break;
		case 4:
			mu1.setImage(green);mu2.setImage(green);mu3.setImage(green);mu4.setImage(green);mu5.setImage(gray);break;
		case 5:
			mu1.setImage(green);mu2.setImage(green);mu3.setImage(green);mu4.setImage(green);mu5.setImage(green);break;
		}
		
		switch(this.sound) {
		case 0:
			so1.setImage(gray);so2.setImage(gray);so3.setImage(gray);so4.setImage(gray);so5.setImage(gray);break;
		case 1:
			so1.setImage(green);so2.setImage(gray);so3.setImage(gray);so4.setImage(gray);so5.setImage(gray);break;
		case 2:
			so1.setImage(green);so2.setImage(green);so3.setImage(gray);so4.setImage(gray);so5.setImage(gray);break;
		case 3:
			so1.setImage(green);so2.setImage(green);so3.setImage(green);so4.setImage(gray);so5.setImage(gray);break;
		case 4:
			so1.setImage(green);so2.setImage(green);so3.setImage(green);so4.setImage(green);so5.setImage(gray);break;
		case 5:
			so1.setImage(green);so2.setImage(green);so3.setImage(green);so4.setImage(green);so5.setImage(green);break;
		}
		
	}
}