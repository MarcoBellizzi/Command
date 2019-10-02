package command;

public class Pulsante {

	int x,y;
	int altezza, larghezza;
	
	public Pulsante(int x, int y, int larghezza, int altezza) {
		this.x = x;
		this.y = y;
		this.larghezza = larghezza;
		this.altezza = altezza;
	}
	
	int getX() { return x; }
	int getY() { return y; }
	int getAltezza() { return altezza; }
	int getLarghezza() { return larghezza; }
	
	public boolean colpito(int c1, int c2) {
		return c1 > x && c1 < x+larghezza && c2 > y && c2 < y+altezza ;
	}
	
	
}
