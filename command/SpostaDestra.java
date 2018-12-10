package command;

public class SpostaDestra extends  Comando {
	
	public SpostaDestra(Navicella p) {
		super(p);
	}

	@Override
	public void esegui(int n) {
		navicella.spostaDestra(n);
		if(navicella.getStato() != "destra")
			navicella.cambiaStato("destra");
	}
	

}
