package Entity;

import javafx.scene.image.ImageView;

public class Item extends ImageView{ //ลักษณะพื้นฐานของ entity
	

	
	private int posX;
	private int posY;
	private int atRow;
	private int atCol;
	
	public Item() {
		
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int  posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
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
	

}
