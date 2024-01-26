package Entity;

public class TeleportBox extends Box{
	private Teleport inside;
	public TeleportBox() {
		super();
		setInside(new Teleport());
		
	}
	public Teleport getInside() {
		return inside;
	}
	public void setInside(Teleport teleport) {
		this.inside = teleport;
	}
	@Override
	public void setAtRow(int atRow) {
		super.setAtRow(atRow);
		inside.setAtRow(atRow);
		inside.setY(69*inside.getAtRow()+4-32);
		inside.setPosY(69*inside.getAtRow()+4-32);
	}
	@Override
	public void setAtCol(int atCol) {
		super.setAtCol(atCol);
		inside.setAtCol(atCol);
		inside.setX(69*inside.getAtCol()+4);
		inside.setPosX(69*inside.getAtCol()+4);
	}
	
}
