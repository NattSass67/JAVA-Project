package Character;

import Application.Main;
import Control.Audio;
import Control.AudioEffect;
import Entity.Posion;
import Entity.RSpike;
import Entity.Teleport;
import Entity.YSpike;
import Field.ObjectField;
import Field.Settings;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Player extends ImageView {
	public static final String HERO_IMAGE_LOC = "http://icons.iconarchive.com/icons/raindropmemory/legendora/64/Hero-icon.png";
	public static final String[] hero= {"file:res/switchRight.png","file:res/HeroLeft.png", "file:res/Hero1Left.png","file:res/kickLeft.png","file:res/onspikeL.png","file:res/attackL.png","file:res/attackL1.png"};
	public static final String[] hero1= {"file:res/switchLeft.png","file:res/Hero1Right.png", "file:res/Hero1Right0.png","file:res/kickRight.png","file:res/onspikeR.png","file:res/attackR.png","file:res/attackR1.png"};
	public static final String[] dieR= {"file:res/die1R.png","file:res/die2R.png","file:res/die3R.png","file:res/die4R.png","file:res/die5R.png","file:res/die6R.png"};
	//private static final  String[] hero1=
	

	private String isDoing;
	private int direction;//Left or Right
	
    private final int[] row= {0,0,0,3,1,4,3,1,4,0,1,3,2,0,3};
	private final int[] col= {1,0,0,0,0,0,0,3,0,4,5,5,0,5,0};
	private final int[] heart= {5,10,9,8,8,11,5,5,9,8,15,11,11,9,14};
	private int health;
	private double posX;
	private double posY;
	private int atRow;
	private int atCol;
	private int goVertical;
	private int goHorizon;
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public int getGoVertical() {
		return goVertical;
	}

	public void setGoVertical(int goVertical) {
		this.goVertical = goVertical;
	}

	public int getGoHorizon() {
		return goHorizon;
	}

	public void setGoHorizon(int goHorizon) {
		this.goHorizon = goHorizon;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}
	public Player(){
		//super(HERO_IMAGE_LOC);
		super(new Image("file:res/Hero1Right.png"));
		setAtRow(row[Main.level]);
		setAtCol(col[Main.level]);
		setPosX(getAtCol()*69);
		setPosY(getAtRow()*69-32);
		setX(getPosX());
		setY(getPosY());
		Thread thread = new Thread(() -> {
			try {
				setMovement();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		thread.start();
		setGoHorizon(0);
		setGoVertical(0);
		setIsDoing("normal");
		setDirection(1);
		setHealth(heart[Main.level]);
		
		
		//setHealth();
		
	}
	
	public void setMovement() {
		String[] Hero=hero1;
		int preset=1;
		int prevDirection=1;
				while(true) {
					if(getDirection()==1){
						Hero=hero1;
					}
					if(getDirection()==-1) {
						Hero=hero;
					}
					if(prevDirection!=getDirection()) {
						preset=0;
						prevDirection=getDirection();
					}
					if(!Main.isUltimate) {
						if(getIsDoing().equals("normal")) {
							switch(preset) {
							case 0:this.setImage(new Image(Hero[0]));preset=1;break;
							case 1:this.setImage(new Image(Hero[1]));preset=2;break;
							case 2:this.setImage(new Image(Hero[2]));preset=1;break;
							default :break;
							}
						}
						else if(getIsDoing().equals("kick")) {
							this.setImage(new Image(Hero[3]));
							setIsDoing("normal");
						}
						//------
						else if(getIsDoing().equals("onspike")) {
							this.setImage(new Image(Hero[4]));
							setIsDoing("normal");
						}
						
						else if(getIsDoing().equals("attack")) {
							this.setImage(new Image(Hero[5]));
							try {
								Thread.sleep(300);
							}
							catch(Exception e) {
								
							}
							this.setImage(new Image(Hero[6]));
							setIsDoing("normal");
						}
						else {
							this.setImage(new Image(Player.HERO_IMAGE_LOC));
							for(int i=0;i<dieR.length;i++) {
								this.setImage(new Image(dieR[i]));
								try {
									Thread.sleep(100);
								}
								catch(Exception e) {
									
								}
							}
							
							break;
						}
						
//						
					}
//				else {
//					this.setImage(new Image(Player.HERO_IMAGE_LOC));
//					}
//					
					try {
						Thread.sleep(300);
					}
					catch(Exception e) {
						
					}
				}
				Audio.setAudio(2);
				Audio.setVolume(Settings.music*0.6);
				Main.isUltimate=true;
			
		
	}


	

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health<0) this.health =0;
		else this.health=health;
	}
	
	public int getAtRow() {
		return atRow;
	}

	public void setAtRow(int atRow) {
		this.atRow = atRow;
	}

	public int getAtCol() {
		return atCol;
	}

	public void setAtCol(int atCol) {
		this.atCol = atCol;
	}
	
	public String getIsDoing() {
		return isDoing;
	}

	public void setIsDoing(String isDoing) {
		this.isDoing = isDoing;
	}

	public void updateOnFloorItem(ObjectField field) {
		if(field.itemAt(atRow, atCol) instanceof YSpike) {
			setHealth(health-2);
			setIsDoing("onspike");
			AudioEffect.setAudio("spike");
		}
		else if(field.itemAt(atRow, atCol) instanceof RSpike) {
			if(((RSpike)field.itemAt(atRow, atCol)).isToggled()) {
				setHealth(health-2);
				setIsDoing("onspike");
				AudioEffect.setAudio("spike");
			}else {
				setHealth(getHealth()-1);
			}
		}
		else if(field.itemAt(atRow, atCol) instanceof Teleport) {
			AudioEffect.setAudio("warp");
			Main.isEnd=true;
			
		}
		else {
			setHealth(health-1);
		}
		
		if(getHealth()==0) {
			setIsDoing("die");
			//Main.ultimate=true;
		}
		
		
	}
	


	
	
	
}
