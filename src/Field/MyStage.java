package Field;



import Application.Main;
import Character.Player;
import Control.Audio;
import Control.AudioEffect;
import Entity.Box;
import Entity.EmptySpace;
import Entity.Posion;
import Entity.PosionBox;
import Entity.RSpike;

import Entity.Rock;
import Entity.RockBox;
import Entity.Teleport;
import Entity.TeleportBox;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class MyStage extends StackPane{
	public boolean moveNow;
	
	private GridMission Mission;
	private Player P;
	private int levelUnlocked;
	private ObjectField room;
	private Heart hBar;
	
	public MyStage(int level) {
		
		BackgroundFill background_fill = new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(background_fill);
		this.setBackground(background);
		this.setStyle("-fx-border-style: solid inside;-fx-border-width:20 "); //setBorder
		room= new ObjectField(level);
		Mission=new GridMission(room);
		Mission.setAlignment(Pos.CENTER);
		P= new Player();
		room.getChildren().add(room.getSizeX()*(P.getAtRow()+1),P);
		StackPane Sp=new StackPane();
		Sp.getChildren().add(room);
		Sp.setMaxHeight(69*room.getSizeX());
		Sp.setMaxWidth(69*room.getSizeY());
		Sp.setAlignment(Pos.CENTER);
		hBar=new Heart(P);
		this.getChildren().addAll(Mission,Sp,hBar);
		setMoveNow(false);
		
		
		Thread thread = new Thread(() -> {  
     		       while(true) {
     		    	   try {
     		    		   ItemAnimate();
     		    		   Thread.sleep(500);
     		    	   }
     		    	   catch(Exception e) {
     		    		   
     		    	   }
     		       }
     		});
        thread.start();
     	

		
		
	}
	public void movePlayer(int x,int y) {
		int fRow=y+P.getAtRow();//position of item frow fcol
		int fCol= x+P.getAtCol();
		
		if(P.getGoHorizon()==-1) {
			P.setDirection(-1);
		}
		if(P.getGoHorizon()==1) {
			P.setDirection(1);
		}
		
		if(room.passAble(fRow, fCol,P.getGoVertical(),P.getGoHorizon()) && P.getHealth()!=0) {
			toggleSpike();
			Platform.runLater(new Runnable(){
				@Override
				public void run() {
					if(y==1) {
						updateRoom(2);
						}
					else {
						updateRoom(1);
						}
					}
				});

				if(room.itemAt(fRow,fCol) instanceof Rock) {
					P.setIsDoing("kick");
					((Rock)room.itemAt(fRow,fCol)).move(x, y);
					room.swapItem(fRow, fCol, fRow+y, fCol+x);
					
					P.updateOnFloorItem(room);
					
				}
				else if(room.itemAt(fRow,fCol) instanceof Box) {
					AudioEffect.setAudio("box");
					if(room.itemAt(fRow,fCol) instanceof PosionBox) {
						P.setIsDoing("attack");
						Platform.runLater(new Runnable(){
							@Override
							public void run() {
								Posion ps=((PosionBox)room.itemAt(fRow,fCol)).getInside();
								int idx=room.getChildren().indexOf(room.itemAt(fRow,fCol));
								((PosionBox)room.itemAt(fRow,fCol)).replace(room,idx,ps);
								room.getObjectList()[fRow][fCol]=null;
								//ps.spawn();
								room.getObjectList()[fRow][fCol]=ps;
								}
							});
					}
					else if(room.itemAt(fRow,fCol) instanceof RockBox){
						P.setIsDoing("attack");
						Platform.runLater(new Runnable(){
							@Override
							public void run() {
								Rock ps=((RockBox)room.itemAt(fRow,fCol)).getInside();
								int idx=room.getChildren().indexOf(room.itemAt(fRow,fCol));
								((RockBox)room.itemAt(fRow,fCol)).replace(room,idx,ps);
								room.getObjectList()[fRow][fCol]=null;
								//ps.spawn();
								room.getObjectList()[fRow][fCol]=ps;
								
								}
							});
					}
					else if(room.itemAt(fRow,fCol) instanceof TeleportBox) {
						P.setIsDoing("attack");
						Platform.runLater(new Runnable(){
							@Override
							public void run() {
								Teleport ps=((TeleportBox)room.itemAt(fRow,fCol)).getInside();
								int idx=room.getChildren().indexOf(room.itemAt(fRow,fCol));
								((TeleportBox)room.itemAt(fRow,fCol)).replace(room,idx,ps);
								room.getObjectList()[fRow][fCol]=null;
								//ps.spawn();
								room.getObjectList()[fRow][fCol]=ps;
							}
						});
						
					}
					else {
						P.setIsDoing("attack");
						((Box)room.itemAt(fRow,fCol)).destroy();
						room.getObjectList()[fRow][fCol]=null;
						room.getObjectList()[fRow][fCol]=new EmptySpace();
					}
					
					P.updateOnFloorItem(room);
					
					
				}

				else {
					AudioEffect.setAudio("run");
					for(int i=0;i<=69;i+=2) {
						P.setX(P.getPosX()+ x*i);
						P.setY(P.getPosY() +y*i);
						try {
						Thread.sleep(20);
						}
						catch(InterruptedException e) {
							e.printStackTrace();
						}
					}
					AudioEffect.stop();
					if(room.itemAt(fRow,fCol) instanceof Posion) {
						AudioEffect.setAudio("posion");
						P.setHealth(P.getHealth()+((Posion)room.itemAt(fRow,fCol)).getRestore());
						((Posion)room.itemAt(fRow,fCol)).setAnimate(false);
						room.getObjectList()[fRow][fCol].setImage(null);
						room.getObjectList()[fRow][fCol]=null;
						room.getObjectList()[fRow][fCol]=new EmptySpace();
					}
					P.setX(P.getPosX()+ x*69);
					P.setY(P.getPosY()+ y*69);
					P.setPosX(P.getPosX()+ x*69);
					P.setPosY(P.getPosY()+ y*69);
					P.setAtRow(P.getAtRow()+y);
					P.setAtCol(P.getAtCol()+x);
					
					P.updateOnFloorItem(room);
					
				
				}
				
		}
		

		hBar.update();	
		this.setPlayerDirection(0, 0);
		setMoveNow(false);
		
	}
	public boolean isMoveNow() {
		return moveNow;
	}
	public void setMoveNow(boolean moveNow) {
		this.moveNow = moveNow;
	}
	
	public void setPlayerDirection(int vertical,int horizontal) {
		P.setGoVertical(vertical);
		P.setGoHorizon(horizontal);
	}
	public void updateRoom(int n) {
		room.getChildren().remove(P);
		room.getChildren().add(room.getSizeX()*(P.getAtRow()+n),P);
		//room.getChildren().add(0,P);
		
	}
	
	public ObjectField getRoom() {
		return room;
	}
	
	public void toggleSpike() {
		for(int i=0;i<room.getChildren().size();i++) {
			if(room.getChildren().get(i) instanceof RSpike) {
				
				((RSpike)room.getChildren().get(i)).toggle();
			}
			
		}
	}
	
	public void ItemAnimate() {
		for(int i=0;i<room.getChildren().size();i++) {
			if(room.getChildren().get(i) instanceof Posion) {
				((Posion)room.getChildren().get(i)).toggle();
			}
			if(room.getChildren().get(i) instanceof Teleport) {
				((Teleport)room.getChildren().get(i)).toggle();
			}
		}
	}
	
	public void setNewMission(int level) {
		room= new ObjectField(level);
		Mission=new GridMission(room);
		Mission.setAlignment(Pos.CENTER);
		P= new Player();
		room.getChildren().add(room.getSizeX()*(P.getAtRow()+1),P);
		StackPane Sp=new StackPane();
		Sp.getChildren().add(room);
		Sp.setMaxHeight(69*room.getSizeX());
		Sp.setMaxWidth(69*room.getSizeY());	
		Sp.setAlignment(Pos.CENTER);
		hBar=new Heart(P);
		this.getChildren().clear();
		this.getChildren().addAll(Mission,Sp,hBar);
		setMoveNow(false);
	}
	
	public void setRoom(ObjectField room) {
		this.room = room;
		
	}
	
}
