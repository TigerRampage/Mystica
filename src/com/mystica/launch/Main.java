package com.mystica.launch;
import com.mystica.component.GamePanel;
import com.mystica.component.Window;

public class Main {

	private static String[] arguments = null;
	public static Window windowInstance = null;
	public static GamePanel panel = null;

	public static void main(String[] args) {

		arguments = args;

		panel = new GamePanel(arguments);
		panel.start();

		windowInstance = new Window(panel);
	}
}