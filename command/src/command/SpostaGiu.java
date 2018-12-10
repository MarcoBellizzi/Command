package command;

public class SpostaGiu extends Comando {

	public SpostaGiu(Navicella p) {
		super(p);
	}

	@Override
	public void esegui(int n) {
		navicella.spostaGiu(n);
		if(navicella.getStato() != "giu")
			navicella.cambiaStato("giu");
	}

}
