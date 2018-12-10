package command;

public abstract class Comando {
	
	Navicella navicella;  // Receiver
	
	public Comando(Navicella p) {
		this.navicella = p;
	}
	
	public void esegui() {};
	
	public void esegui(int n) {};
	
}
