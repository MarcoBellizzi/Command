package command;

public class SpostaSu extends Comando {

	public SpostaSu(Navicella p) {
		super(p);
	}

	@Override
	public void esegui(int n) {
		navicella.spostaSu(n);
		if(navicella.getStato() != "su")
			navicella.cambiaStato("su");
	}

}
