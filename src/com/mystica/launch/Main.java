package com.mystica.launch;


public class Main {
	
	private static String[] arguments = null;
	public static Window windowInstance = null;
	
	public static void main(String[] args) {
		
		arguments = args;
		
		windowInstance = new Window(new GamePanel(arguments));
	}
}