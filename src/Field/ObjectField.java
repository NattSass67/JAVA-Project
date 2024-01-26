package Field;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import Character.Player;
import Entity.Box;
import Entity.EmptySpace;
import Entity.HighWall;
import Entity.Item;
import Entity.Posion;
import Entity.PosionBox;
import Entity.RSpike;

import Entity.Rock;
import Entity.RockBox;
import Entity.Teleport;
import Entity.TeleportBox;
import Entity.YSpike;
import javafx.scene.layout.Pane;

public class ObjectField extends Pane{
	private static final String[] listWorld= {"res/level1.txt","res/level2.txt","res/level3.txt","res/level4.txt","res/level5.txt","res/level6.txt","res/level7.txt","res/level8.txt","res/level9.txt","res/level10.txt","res/level11.txt","res/level12.txt","res/level13.txt","res/level14.txt","res/level15.txt"};
	private final int[] worldSize= {4,4,4,5,5,5,5,5,5,6,6,7,8,6,8};
	private  int sizeX;
	private  int sizeY;
	private Item[][] objList;
	
	public ObjectField(int level) {
		setSizeX(worldSize[level]);
		setSizeY(worldSize[level]);
//		P= new Player();
//		P.setAtRow(1);
		this.setWidth(69*worldSize[level]);
		this.setHeight(69*worldSize[level]); 
		objList=new Item[sizeX][sizeY];
		loadWorld(level);
		showUp();
//		this.getChildren().add(P);
		
	}
	
	public void loadWorld(int level) {
		try {
		      File myObj = new File(listWorld[level]);
		      Scanner myReader = new Scanner(myObj);
		      int row=0;
		      while (myReader.hasNextLine()&& row<worldSize[level]) {
		        String data = myReader.nextLine();
		        String[] splitData=data.split(" ");
		        for(int i=0;i<splitData.length;i++) {
		        	Item O;
		        	switch(splitData[i]) {
		        	case "0":O=new Box();break;
		        	case "1":O=new Rock();break;
		        	case "2":O=new YSpike();break;
		        	case "3":O=new HighWall();break;
		        	case "41":O=new RSpike(1);break;
		        	case "42":O=new RSpike(2);break;
		        	
		        	case "50":O=new Posion(0);break;
		        	case "51":O=new Posion(1);break;
		        	case "52":O=new Posion(2);break;
		        	case "53":O=new Posion(3);break;
		        	case "54":O=new Posion(4);break;
		        	case "55":O=new Posion(5);break;
		        	case "56":O=new Posion(6);break;
		        	case "57":O=new Posion(7);break;
		        	case "511":O=new Posion(11);break;
		        	
		        	case "6":O=new Teleport();break;
		        	case "61" :O=new TeleportBox();break;
		        	case "70":O=new PosionBox(0);break;
		        	case "71":O=new PosionBox(1);break;
		        	case "72":O=new PosionBox(2);break;
		        	case "73":O=new PosionBox(3);break;
		        	case "74":O=new PosionBox(4);break;
		        	case "75":O=new PosionBox(5);break;
		        	case "76":O=new PosionBox(6);break;
		        	case "78":O=new PosionBox(8);break;
		        	case "710":O=new PosionBox(10);break;
		        	case "711":O=new PosionBox(11);break;
		        	
		        	
		        	case "8":O=new RockBox();break;
		        	default : O=new EmptySpace();break;
		        	}
		        	if(!(O instanceof HighWall ||O instanceof Teleport)) {
			        	O.setPosX(i*69+4);
			        	O.setPosY(row*69+4);
			        	O.setX(i*69+4);
			        	O.setY(row*69+4);
		        	}
		        	else {
		        		O.setPosX(i*69+4);
			        	O.setPosY(row*69-32);
			        	O.setX(i*69+4);
			        	O.setY(row*69-32);
		        	}
		        	O.setAtRow(row);
		        	O.setAtCol(i);
		        	objList[row][i]=O;
		        }
		        row++;
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public void showUp() {
		for(int i=0;i<objList.length;i++) {
			for(int j=0;j<objList[i].length;j++) {
					this.getChildren().add(objList[i][j]);
				
			}
		}
	}
	
	public boolean passAble(int row,int col,int goVertical,int goHorizon) {
		if(!(row<sizeY && 0<=row && col<sizeX && 0<=col)) {
			return false;
		}
		if(objList[row][col] instanceof Box || objList[row][col] instanceof Posion || objList[row][col] instanceof Teleport) {
			return true;
		}
		if(objList[row][col] instanceof EmptySpace) {
			return true;
		}
		if(objList[row][col] instanceof YSpike || objList[row][col] instanceof RSpike ) {
			return true;
		}
		if(objList[row][col] instanceof Rock) {
			if(goVertical==-1 && row+1<sizeY) {
				if(objList[row+1][col] instanceof EmptySpace) {
					return true;
				}
			}
			if(goHorizon==1 && col+1<sizeX) {
				if(objList[row][col+1] instanceof EmptySpace) {
					return true;
				}
				
			}
			if(goVertical==1 && row-1>=0) {
				if(objList[row-1][col] instanceof EmptySpace) {
					return true;
				}
				
			}
			if(goHorizon==-1 && col-1>=0) {
				if(objList[row][col-1] instanceof EmptySpace) {
					return true;
				}
				
			}
		}		
		return false;
	}

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}
	
	public Item itemAt(int row,int col) {
		return objList[row][col];
	}
	
	public void swapItem(int row1,int col1,int row2,int col2) {
		Item a=itemAt(row1, col1);
		Item b=itemAt(row2, col2);
		objList[row1][col1]=b;
		objList[row2][col2]=a;
	};
	public Item[][] getObjectList() {
		return objList;
	}
	
	
	
	
	
	
	

	
	
	
	
	

}
