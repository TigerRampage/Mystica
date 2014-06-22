package com.mystica.component;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;

import javax.swing.JPanel;

import com.mystica.util.LoggingUtil;

public class GamePanel extends JPanel implements Runnable {
	
	private static final long serialVersionUID = -5198592492560424740L;

	private String[] arguments = null;
	
	private boolean isRunning = false;
	private Thread thread;
	
	public synchronized void start() {
		if (isRunning) {
			return;
		}
		
		this.isRunning = true;
		this.thread = new Thread(this);
		this.thread.start();
	}
	
	public GamePanel(String[] args) {
		this.createGame(args);
	}
	
	public void createGame(String[] args) {
		this.arguments = args;
		
		if (arguments.length > 0) {
			for (String s : arguments) {
				//TODO: assign specific functions to each arg and fill with if statements
			}
		}
	}
	
	public void beginGameLoop() {
		long beginTime = System.nanoTime();
		double ticks = 60.0D;
		double ns = 100000000 / ticks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while (this.isRunning) {
			long currentTime = System.nanoTime();
			delta += (currentTime - beginTime) / ns;
			beginTime = currentTime;
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			this.repaint();
			frames++;
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				LoggingUtil.getLogger().log(Level.INFO, "Ticks: " + ticks + "       FPS: " + frames);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	private void tick() {
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
	}

	@Override
	public void run() {
		LoggingUtil.getLogger().log(Level.INFO, "Thread is starting");
		this.beginGameLoop();
	}
}
