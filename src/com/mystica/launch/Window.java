package com.mystica.launch;

import javax.swing.JFrame;

public class Window {

	public Window(GamePanel panel) {
		JFrame f = new JFrame("Mystica");
		f.add(panel);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
