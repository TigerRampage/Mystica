package com.mystica.launch;
import com.mystica.component.Window;

public class Main {

	private static String[] arguments = null;
	public static Window windowInstance = null;
	public static Game game = null;

	public static void main(String[] args) {
		arguments = args;
		game = new Game(arguments);
		windowInstance = new Window(game);
		game.start();
	}
}