package command;

public class Colpo {

	int x,y;
	int altezza;
	boolean visible;
	String stato;
	
	public Colpo() {
		x = 0;
		y = 0;
		altezza = 100;
		visible = false;
		stato = "giu";
	}
	
	
	
	public int getX() { return x; }
	public void setX(int c) { x = c; }
	public int getY() { return y; }	
	public void setY(int c) { y = c; }
	public int getAltezza() { return altezza; }
	public boolean getVisible() { return visible; }
	public void setVisible(boolean v) { visible = v; } 
	public String getStato() { return stato; }
	public void setStato(String s) { stato = s; }

}
