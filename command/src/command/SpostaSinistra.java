package command;

public class SpostaSinistra extends Comando {

	public SpostaSinistra(Navicella p) {
		super(p);
	}

	@Override
	public void esegui(int n) {
		navicella.spostaSinistra(n);
		if(navicella.getStato() != "sinistra")
			navicella.cambiaStato("sinistra");
	}

	
	
}
