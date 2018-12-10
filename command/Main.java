package command;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Pannello pannello = new Pannello();
		frame.setSize(1000, 550);
		frame.setLocation(200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(pannello);
		frame.setVisible(true);
	}

}
