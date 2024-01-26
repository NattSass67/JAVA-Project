package Application;



import java.io.File;
import java.util.concurrent.ExecutionException;

import Character.Player;
import Control.Audio;
import Field.Controller;
import Field.Maps;
import Field.Menu;
import Field.MyStage;
import Field.ObjectField;
import Field.Settings;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.media.*;


public class Main extends Application{
	public boolean isProcess=false;
	public static boolean isUltimate=false;
	public static boolean isEnd=false;
	public static int level=0;
	
	 public  MyStage field =new MyStage(0);
	 public Menu menu=new Menu();
	 public Settings set=new Settings();
	 public Controller control=new Controller();
	 public Maps map =new Maps();
	 public Scene scene = new Scene(field,1200,800);
	 public Scene scene1= new Scene(menu);
	 public Scene scene2=new Scene(set);
	 public Scene scene3=new Scene(control);
	 public Scene scene4=new Scene(map);
	 public Scene scene5;
	 
	 
	 
	 public void start(Stage stage) throws Exception {
		  File mediaFile = new File("res/the end.mp4");
		  Media media = new Media(mediaFile.toURI().toURL().toString());
	        MediaPlayer mediaPlayer = new MediaPlayer(media);
	        MediaView mediaView = new MediaView(mediaPlayer);
	        Group root = new Group();  
	        root.getChildren().add(mediaView) ; 
	        mediaView.setPreserveRatio(true);
	        mediaView.setFitHeight(720);
	        scene5 = new Scene(root,1280,720);  
	        
		 
	     
	     scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
	            @Override
	            public void handle(KeyEvent event) {
	            	
	            	Thread thread = new Thread(() -> {  
	            		if(!isUltimate) {
	            			
	            			setMove(event); 
	            		}
	            		if(event.getCode()==KeyCode.ESCAPE) {
	            			
	            			 Platform.runLater(new Runnable(){
	            	 				@Override
	            	 				public void run() {
	            	 					stage.setScene(scene1);
	            	         			Audio.setAudio(1);
	            	 					}
	            	 				});
	            		}
	            		if(event.getCode()==KeyCode.R && !isUltimate) {
	            			
	            			 Platform.runLater(new Runnable(){
	            	 				@Override
	            	 				public void run() {
	            	 					field.setNewMission(level);
	            	 					stage.setScene(scene);
	            	         			Audio.setAudio(1);
	            	 					}
	            	 				});
	            		}
	            		if(isEnd ) {
	            			Platform.runLater(new Runnable(){
	            				@Override
	            				public void run() {
	            					if(level!=14) {
		            					field.setNewMission(++level);
		            					Maps.unlockLevel(level);
		            					map.reset();
		    	            			isEnd=false;
		    	            			isUltimate=false;
		    	            			Audio.setAudio(1);
	            					}
	            					else {
	            						stage.setScene(scene5);
	            						mediaPlayer.play();
	            						}
	            					}
	            				});
	            			
	            			}
	            		
	            		
	            		});
	            	thread.start();
	            	
	            	}
	            
	             });
	     
	     stage.setScene(scene1);
	     stage.show();
	     Audio.setAudio(1);
	     Audio.setVolume(Settings.music);
	     stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		       @Override
		       
		       public void handle(WindowEvent e) {
		          Platform.exit();
		          System.exit(0);
		       }
		    });
	     
	     //----------------------------------------------------Next Level
	     Menu.start.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    		public void handle(MouseEvent event) {
	    			stage.setScene(scene3);
	    		}
	    	});
	     Menu.Options.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    		public void handle(MouseEvent event) {
	    			stage.setScene(scene2);
	    		}
	    	});
	     Menu.Quit.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    		public void handle(MouseEvent event) {
	    			 Platform.exit();
			          System.exit(0);
	    		}
	    	});
	     Settings.continues.setOnMouseReleased(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent arg0) {
					stage.setScene(scene1);
				}
				
			});
	     Controller.next.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    		public void handle(MouseEvent event) {
	    			stage.setScene(scene4);
	    		}
	    	});
	     Controller.back.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    		public void handle(MouseEvent event) {
	    			stage.setScene(scene1);
	    		}
	    	});
	     Maps.back.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    		public void handle(MouseEvent event) {
	    			stage.setScene(scene3);
	    		}
	    	});
	     //Select map
	     Thread thread1 = new Thread(() -> {  
		       while(true) {
		    	   try {
						Thread.sleep(300);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
		    	   if(level==14 && isEnd) {
           			try {
           				Thread.sleep(13000);
           				Platform.runLater(new Runnable(){
	            				@Override
	            				public void run() {
	            						stage.setScene(scene1);
	            				}
           				});
           			
           			}
           			catch(Exception e) {
           				
           			}
           		}
		    	   if(isUltimate) {
		    		   try {
   						Thread.sleep(8000);
   					}
   					catch(Exception e) {
   						e.printStackTrace();
   					}
		    		  
	         			Platform.runLater(new Runnable(){
            				@Override
            				public void run() {
            					 field.setNewMission(level);
         	         			isEnd=false;
         	         			isUltimate=false;
         	         			Audio.setAudio(1);
      		    			   
            					}
            				});   
		    	   }
		    	 if(Maps.isClick ) {
		    			   Platform.runLater(new Runnable(){
	            				@Override
	            				public void run() {
	            				   field.setNewMission(level);
	      		    			   stage.setScene(scene);
	      		    			   Maps.isClick=false;
	      		    			   
	            					}
	            				});   
		    		   }
		    		
		       }
		});
	    thread1.start(); 			
		    		  
		    		  
		    	 
			    	  

     	//---------------------------------------------------
		
	     
	   
	 }
	 public void setMove(KeyEvent event) {

		if(!field.isMoveNow() && !isProcess) {
			isProcess=true;
			if(event.getCode()==KeyCode.W) {
				field.setMoveNow(true);
				field.setPlayerDirection(1, 0);//go up
				field.movePlayer(0, -1);
				
				
		       }
			if(event.getCode()==KeyCode.A) {
				field.setMoveNow(true);
				field.setPlayerDirection(0, -1);//go left
				field.movePlayer(-1, 0);
				
			}
			if(event.getCode()==KeyCode.S) {
				field.setMoveNow(true);
				field.setPlayerDirection(-1, 0);//go down
				field.movePlayer(0, 1);
			}
			if(event.getCode()==KeyCode.D) {
				field.setMoveNow(true);
				field.setPlayerDirection(0, 1);//go right
				field.movePlayer(1, 0);
			}
			try {
				Thread.sleep(300);
				isProcess=false;
				}
				catch(Exception e) {}
		}
			

	}

	 
	 public static void main(String[] args) { launch(args); }
}