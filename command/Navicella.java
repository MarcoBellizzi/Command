package command;

import java.util.ArrayList;

public class Navicella {

	int x,y,larghezza,altezza;
	String stato;
	ArrayList<Colpo> colpi;
	
	public Navicella(int x, int y, int larghezza, int altezza) {
		this.x = x;
		this.y = y;
		this.larghezza = larghezza;
		this.altezza = altezza;
		stato = "giu";
		colpi = new ArrayList<Colpo>();
		colpi.add(new Colpo());
		colpi.add(new Colpo());
		colpi.add(new Colpo());
		colpi.add(new Colpo());
		colpi.add(new Colpo());
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public int getLarghezza() { return larghezza; }
	public int getAltezza() { return altezza; }
	
	public void spostaDestra(int n) { x += n; }
	public void spostaSinistra(int n) { x -= n; }
	public void spostaSu(int n) { y -= n; }
	public void spostaGiu(int n) { y += n; }
	
	public void cambiaStato(String s) { stato = s; }
	public String getStato() { return stato; }
	
	public ArrayList<Colpo> getColpi() { return colpi; }
	
}
