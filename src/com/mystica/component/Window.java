package com.mystica.component;
import javax.swing.JFrame;

import com.mystica.launch.Game;

public class Window {

	
	public Window(Game panel) {
		JFrame f = new JFrame("Mystica");
		f.add(panel);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setResizable(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
