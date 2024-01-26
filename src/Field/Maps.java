package Field;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import Application.Main;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Maps extends Pane{
	private static String[] unlock;
	public static ImageView back = new ImageView(new Image("file:res/Back.png"));
	public static boolean isClick = false;
	private ImageView map1 = new ImageView(new Image("file:res/1.png"));
	private ImageView map2 = new ImageView(new Image("file:res/2.png"));
	private ImageView map3 = new ImageView(new Image("file:res/3.png"));
	private ImageView map4 = new ImageView(new Image("file:res/4.png"));
	private ImageView map5 = new ImageView(new Image("file:res/5.png"));
	private ImageView map6 = new ImageView(new Image("file:res/6.png"));
	private ImageView map7 = new ImageView(new Image("file:res/7.png"));
	private ImageView map8 = new ImageView(new Image("file:res/8.png"));
	private ImageView map9 = new ImageView(new Image("file:res/9.png"));
	private ImageView map10 = new ImageView(new Image("file:res/10.png"));
	private ImageView map11 = new ImageView(new Image("file:res/11.png"));
	private ImageView map12 = new ImageView(new Image("file:res/12.png"));
	private ImageView map13 = new ImageView(new Image("file:res/13.png"));
	private ImageView map14 = new ImageView(new Image("file:res/14.png"));
	private ImageView map15 = new ImageView(new Image("file:res/15.png"));
	
	
	public Maps(){
		createUnlock();
		ImageView Im = new ImageView(new Image("file:res/menu01.jpg"));
		Im.setPreserveRatio(true);
		Im.setFitHeight(700);
		this.getChildren().add(Im);
		
		ImageView Maps = new ImageView(new Image("file:res/Map.png"));
		Maps.setPreserveRatio(true);
		Maps.setFitWidth(600);
		this.getChildren().add(Maps);
		Maps.setX(395);
		Maps.setY(120);
		
		back.setPreserveRatio(true);
		back.setFitWidth(75);
		this.getChildren().add(back);
		back.setX(640);
		back.setY(490);
//		
//		ImageView map1 = new ImageView(new Image("file:res/1.png"));
//		ImageView map2 = new ImageView(new Image("file:res/2.png"));
//		ImageView map3 = new ImageView(new Image("file:res/3.png"));
//		ImageView map4 = new ImageView(new Image("file:res/4.png"));
//		ImageView map5 = new ImageView(new Image("file:res/5.png"));
//		ImageView map6 = new ImageView(new Image("file:res/6.png"));
//		ImageView map7 = new ImageView(new Image("file:res/7.png"));
//		ImageView map8 = new ImageView(new Image("file:res/8.png"));
//		ImageView map9 = new ImageView(new Image("file:res/9.png"));
//		ImageView map10 = new ImageView(new Image("file:res/10.png"));
//		ImageView map11 = new ImageView(new Image("file:res/11.png"));
//		ImageView map12 = new ImageView(new Image("file:res/12.png"));
//		ImageView map13 = new ImageView(new Image("file:res/13.png"));
//		ImageView map14 = new ImageView(new Image("file:res/14.png"));
//		ImageView map15 = new ImageView(new Image("file:res/15.png"));
		if(unlock[0].equals("0")) map1.setImage(new Image("file:res/lock.png"));
		if(unlock[1].equals("0")) map2.setImage(new Image("file:res/lock.png"));
		if(unlock[2].equals("0")) map3.setImage(new Image("file:res/lock.png"));
		if(unlock[3].equals("0")) map4.setImage(new Image("file:res/lock.png"));
		if(unlock[4].equals("0")) map5.setImage(new Image("file:res/lock.png"));
		if(unlock[5].equals("0")) map6.setImage(new Image("file:res/lock.png"));
		if(unlock[6].equals("0")) map7.setImage(new Image("file:res/lock.png"));
		if(unlock[7].equals("0")) map8.setImage(new Image("file:res/lock.png"));
		if(unlock[8].equals("0")) map9.setImage(new Image("file:res/lock.png"));
		if(unlock[9].equals("0")) map10.setImage(new Image("file:res/lock.png"));
		if(unlock[10].equals("0")) map11.setImage(new Image("file:res/lock.png"));
		if(unlock[11].equals("0")) map12.setImage(new Image("file:res/lock.png"));
		if(unlock[12].equals("0")) map13.setImage(new Image("file:res/lock.png"));
		if(unlock[13].equals("0")) map14.setImage(new Image("file:res/lock.png"));
		if(unlock[14].equals("0")) map15.setImage(new Image("file:res/lock.png"));
		map1.setPreserveRatio(true);
		map1.setFitWidth(70);
		map2.setPreserveRatio(true);
		map2.setFitWidth(70);
		map3.setPreserveRatio(true);
		map3.setFitWidth(70);
		map4.setPreserveRatio(true);
		map4.setFitWidth(70);
		map5.setPreserveRatio(true);
		map5.setFitWidth(70);
		map6.setPreserveRatio(true);
		map6.setFitWidth(71);
		map7.setPreserveRatio(true);
		map7.setFitWidth(73);
		map8.setPreserveRatio(true);
		map8.setFitWidth(70);
		map9.setPreserveRatio(true);
		map9.setFitWidth(70);
		map10.setPreserveRatio(true);
		map10.setFitWidth(85);
		map11.setPreserveRatio(true);
		map11.setFitWidth(85);
		map12.setPreserveRatio(true);
		map12.setFitWidth(86);
		map13.setPreserveRatio(true);
		map13.setFitWidth(85);
		map14.setPreserveRatio(true);
		map14.setFitWidth(86);
		map15.setPreserveRatio(true);
		map15.setFitWidth(85);
		this.getChildren().addAll(map1,map2,map3,map4,map5,map6,map7,map8,map9,map10,map11,map12,map13,map14,map15);
		map1.setX(480);
		map1.setY(260);
		map2.setX(560);
		map2.setY(260);
		map3.setX(640);
		map3.setY(260);
		map4.setX(720);
		map4.setY(260);
		map5.setX(800);
		map5.setY(260);
		map6.setX(480);
		map6.setY(337);
		map7.setX(560);
		map7.setY(337);
		map8.setX(640);
		map8.setY(337);
		map9.setX(720);
		map9.setY(337);
		map10.setX(794);
		map10.setY(337);
		map11.setX(474);
		map11.setY(414);
		map12.setX(554);
		map12.setY(414);
		map13.setX(634);
		map13.setY(414);
		map14.setX(714);
		map14.setY(414);
		map15.setX(794);
		map15.setY(414);
		
		map1.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				
				if(unlock[0].equals("1")) {
				Main.level = 0;
				isClick = true;
				}
			}
		});
		map2.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				if(unlock[1].equals("1")) {
				Main.level = 1;
				isClick = true;
				}
			}
		});
		map3.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				if(unlock[2].equals("1")) {
				Main.level = 2;
				isClick = true;
				}
			}
		});
		map4.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				if(unlock[3].equals("1")) {
				Main.level = 3;
				isClick = true;
				}
			}
		});
		map5.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				if(unlock[4].equals("1")) {
				Main.level = 4;
				isClick = true;
				}
			}
		});
		map6.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				if(unlock[5].equals("1")) {
				Main.level = 5;
				isClick = true;
				}
			}
		});
		map7.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				if(unlock[6].equals("1")) {
				Main.level = 6;
				isClick = true;
				}
			}
		});
		map8.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				if(unlock[7].equals("1")) {
				Main.level = 7;
				isClick = true;
				}
			}
		});
		map9.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				if(unlock[8].equals("1")) {
				Main.level = 8;
				isClick = true;
				}
			}
		});
		map10.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				if(unlock[9].equals("1")) {
				Main.level = 9;
				isClick = true;
				}
			}
		});
		map11.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				if(unlock[10].equals("1")) {
				Main.level = 10;
				isClick = true;
				}
			}
		});
		map12.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				if(unlock[11].equals("1")) {
				Main.level = 11;
				isClick = true;
				}
			}
		});
		map13.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				if(unlock[12].equals("1")) {
				Main.level = 12;
				isClick = true;
				}
			}
		});
		map14.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				if(unlock[13].equals("1")) {
				Main.level = 13;
				isClick = true;
				}
			}
		});
		map15.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent arg0) {
				if(unlock[14].equals("1")) {
				Main.level = 14;
				isClick = true;
				}
			}
		});
	}
	
	public void createUnlock() {
		try {
		      File myObj = new File("res/passed.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        unlock=data.split(" ");
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public static void unlockLevel(int level) {
		unlock[level]="1";
		try {
			PrintWriter pw = new PrintWriter("res/passed.txt");
			pw.close();
			}
			catch(Exception e) {
				
			}
		try {
		      FileWriter myWriter = new FileWriter("res/passed.txt");
		      String s="";
		      for(int i=0;i<unlock.length;i++) {
		    	  s+=unlock[i]+" ";
		      }
		      myWriter.write(s);
		      myWriter.close();
		      
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
	}
	public void reset() {
		map1.setImage(new Image("file:res/1.png"));
		 map2.setImage(new Image("file:res/2.png"));
		 map3.setImage(new Image("file:res/3.png"));
		 map4.setImage(new Image("file:res/4.png"));
		 map5.setImage(new Image("file:res/5.png"));
		 map6.setImage(new Image("file:res/6.png"));
		 map7.setImage(new Image("file:res/7.png"));
		 map8.setImage(new Image("file:res/8.png"));
		 map9.setImage(new Image("file:res/9.png"));
		 map10.setImage(new Image("file:res/10.png"));
		 map11.setImage(new Image("file:res/11.png"));
		 map12.setImage(new Image("file:res/12.png"));
		 map13.setImage(new Image("file:res/13.png"));
		 map14.setImage(new Image("file:res/14.png"));
		 map15.setImage(new Image("file:res/15.png"));
		if(unlock[0].equals("0")) map1.setImage(new Image("file:res/lock.png"));
		if(unlock[1].equals("0")) map2.setImage(new Image("file:res/lock.png"));
		if(unlock[2].equals("0")) map3.setImage(new Image("file:res/lock.png"));
		if(unlock[3].equals("0")) map4.setImage(new Image("file:res/lock.png"));
		if(unlock[4].equals("0")) map5.setImage(new Image("file:res/lock.png"));
		if(unlock[5].equals("0")) map6.setImage(new Image("file:res/lock.png"));
		if(unlock[6].equals("0")) map7.setImage(new Image("file:res/lock.png"));
		if(unlock[7].equals("0")) map8.setImage(new Image("file:res/lock.png"));
		if(unlock[8].equals("0")) map9.setImage(new Image("file:res/lock.png"));
		if(unlock[9].equals("0")) map10.setImage(new Image("file:res/lock.png"));
		if(unlock[10].equals("0")) map11.setImage(new Image("file:res/lock.png"));
		if(unlock[11].equals("0")) map12.setImage(new Image("file:res/lock.png"));
		if(unlock[12].equals("0")) map13.setImage(new Image("file:res/lock.png"));
		if(unlock[13].equals("0")) map14.setImage(new Image("file:res/lock.png"));
		if(unlock[14].equals("0")) map15.setImage(new Image("file:res/lock.png"));
		
	}
}