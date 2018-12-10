package command;

public class Spara extends Comando {

	public Spara(Navicella p) {
		super(p);
	}

	@Override
	public void esegui() {
		for(Colpo colpo : navicella.getColpi()) {
			if(!colpo.getVisible()) {
				colpo.setStato(navicella.getStato());
				colpo.setX(navicella.getX());
				colpo.setY(navicella.getY());
				colpo.setVisible(true);
				break;
			}
		}
	}

}
