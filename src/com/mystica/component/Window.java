package com.mystica.component;

import javax.swing.JFrame;


public class Window {

	private GridPanel gp = new GridPanel();
	
	public Window(GamePanel panel) {
		JFrame f = new JFrame("Mystica");
		f.add(panel);
		f.add(gp);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
