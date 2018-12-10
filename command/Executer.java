package command;

public class Executer extends Thread {

	Pannello p;
	int x,y;
	
	public Executer(Pannello p) {
		this.p = p;
		x = 0;
		y = 0;
	}
	
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }

	
	@Override
	public void run() {
		super.run();
		
		while(true) {
			
			p.updateUI(); 
			p.repaint();
			
			if(p.destra.colpito(x,y)) 
				p.spostaDestra.esegui(2);
			
			if(p.sinistra.colpito(x,y)) 
				p.spostaSinistra.esegui(2);
			
			if(p.su.colpito(x,y)) 
				p.spostaSu.esegui(2);
			
			if(p.giu.colpito(x,y)) 
				p.spostaGiu.esegui(2);
			
			
			for(Colpo colpo : p.navicella.getColpi()) {
				if(colpo.getVisible()) {
					switch(colpo.getStato()) {
					case "giu" : {
						colpo.setY(colpo.getY()+2);
						break;
					}
					case "su" : {
						colpo.setY(colpo.getY()-2);
						break;
					}
					case "destra" : {
						colpo.setX(colpo.getX()+2);
						break;
					}
					case "sinistra" : {
						colpo.setX(colpo.getX()-2);
						break;
					}
					}
					if(colpo.getX() > 1000 || colpo.getX() < 0 || colpo.getY() > 550 || colpo.getY() < 0)
						colpo.setVisible(false);
				}
			}
			
			
			try {
				sleep(10);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	

}
