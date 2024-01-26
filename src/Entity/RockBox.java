package Entity;

public class RockBox extends Box{
	private Rock inside;
	public RockBox() {
		super();
		setInside(new Rock());
		
	}
	public Rock getInside() {
		return inside;
	}
	public void setInside(Rock inside) {
		this.inside = inside;
	}
	@Override
	public void setAtRow(int atRow) {
		super.setAtRow(atRow);
		inside.setAtRow(atRow);
		inside.setY(69*inside.getAtRow()+4);
		inside.setPosY(69*inside.getAtRow()+4);
	}
	@Override
	public void setAtCol(int atCol) {
		super.setAtCol(atCol);
		inside.setAtCol(atCol);
		inside.setX(69*inside.getAtCol()+4);
		inside.setPosX(69*inside.getAtCol()+4);
	}
	
}
