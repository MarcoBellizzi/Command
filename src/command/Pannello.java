package command;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Pannello extends JPanel {     // Client
	
	Navicella navicella;     // Receiver
	
	Comando spostaDestra,    // ConcreteComands
		spostaSinistra,
		spostaSu,
		spostaGiu,
		spara;
	
	Executer esecutore;    // Invoker (da mouse)
	
	Pulsante sinistra, destra, su, giu, fire;

	Image Isinistra, Idestra, Isu, Igiu, sfondo,
		alienr, alienl, alienu, aliend, sfera, Ifire;

	
	private static final long serialVersionUID = 1L;

	public Pannello() {
		super();
		initGUI();
		initEH();
	}

	public void initGUI()  {
		this.setFocusable(true);
		
		navicella = new Navicella(200,200,100,100);
		
		spostaDestra = new SpostaDestra(navicella);
		spostaSinistra = new SpostaSinistra(navicella);
		spostaSu = new SpostaSu(navicella);
		spostaGiu = new SpostaGiu(navicella);
		spara = new Spara(navicella);
		
		sinistra = new Pulsante(600,200,100,100);
		su = new Pulsante(725,50,100,100);
		destra = new Pulsante(850,200,100,100);
		giu = new Pulsante(725,350,100,100);
		fire = new Pulsante(725,200,100,100);
		
		esecutore = new Executer(this);
		esecutore.start();
		
		try {
			Idestra = ImageIO.read(new File("src/command/destra.png"));
			Isinistra = ImageIO.read(new File("src/command/sinistra.png"));
			Isu = ImageIO.read(new File("src/command/su.png"));
			Igiu = ImageIO.read(new File("src/command/giu.png"));
			sfondo = ImageIO.read(new File("src/command/sfondo.jpg"));
			
			alienr = ImageIO.read(new File("src/command/alien(destra).png"));
			alienl = ImageIO.read(new File("src/command/alien(sinistra).png"));
			alienu = ImageIO.read(new File("src/command/alien(su).png"));
			aliend = ImageIO.read(new File("src/command/alien(giu).png"));
			//sfera = ImageIO.read(new File("src/command/ball.gif"));
			Ifire = ImageIO.read(new File("src/command/spara.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sfera = loadAssets("ball.gif");
	}

	public void initEH() {

		this.addKeyListener(new KeyAdapter() {  // Invoker (da tastiera)

			@Override
			public void keyPressed(KeyEvent e) {

				super.keyPressed(e);

				switch(e.getKeyCode()) {
				case(KeyEvent.VK_RIGHT) : {
					spostaDestra.esegui(5);
					break;
				}
				case(KeyEvent.VK_LEFT) : {
					spostaSinistra.esegui(5);
					break;
				}
				case(KeyEvent.VK_UP) : {
					spostaSu.esegui(5);
					break;
				}
				case(KeyEvent.VK_DOWN) : {
					spostaGiu.esegui(5);
					break;
				}
				case(KeyEvent.VK_SPACE) : {
					spara.esegui();
				}
				}	
			}
		});

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(fire.colpito(e.getX(), e.getY()))  {
					spara.esegui();
				}
					
			}

		});
		
		this.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				esecutore.setX(e.getX());
				esecutore.setY(e.getY());
			}
			
		});
		
	}

	public Image loadAssets(String path) {
		URL url = this.getClass().getResource(path);
		Image img = Toolkit.getDefaultToolkit().getImage(url);
		return img;
	}



	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(sfondo, 0, 0, 1000, 550, this);
		
		g.drawImage(Isinistra, sinistra.getX(), sinistra.getY(), sinistra.getAltezza(), sinistra.getLarghezza(), this);
		g.drawImage(Isu, su.getX(), su.getY(), su.getAltezza(), su.getLarghezza(), this);
		g.drawImage(Idestra, destra.getX(), destra.getY(), destra.getAltezza(), destra.getLarghezza(), this);
		g.drawImage(Igiu, giu.getX(), giu.getY(), giu.getAltezza(), giu.getLarghezza(), this);
		g.drawImage(Ifire, fire.getX(), fire.getY(), fire.getAltezza(), fire.getAltezza(), this);

		switch(navicella.getStato()) {
		case "giu" : {
			g.drawImage(aliend, navicella.getX(), navicella.getY(), navicella.getLarghezza(), navicella.getAltezza(), this);
			break;
		}
		case "su" : {
			g.drawImage(alienu, navicella.getX(), navicella.getY(), navicella.getLarghezza(), navicella.getAltezza(), this);
			break;
		}
		case "destra" : {
			g.drawImage(alienr, navicella.getX(), navicella.getY(), navicella.getLarghezza(), navicella.getAltezza(), this);
			break;
		}
		case "sinistra" : {
			g.drawImage(alienl, navicella.getX(), navicella.getY(), navicella.getLarghezza(), navicella.getAltezza(), this);
			break;
		}
		}
		
		for(Colpo colpo : navicella.getColpi())
			if(colpo.getVisible())
				g.drawImage(sfera, colpo.getX(), colpo.getY(), colpo.getAltezza(), colpo.getAltezza(), this);
		
	
	}

	

}
