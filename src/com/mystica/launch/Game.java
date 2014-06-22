package com.mystica.launch;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;

import com.mystica.component.Grid;
import com.mystica.util.LoggingUtil;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = -5198592492560424740L;

	private String[] arguments = null;
	
	private boolean isRunning = false;
	private Thread thread;
	
	private int tickCount = 0;
	
	public synchronized void start() {
		if (isRunning) {
			return;
		}
		
		this.isRunning = true;
		this.thread = new Thread(this);
		this.thread.start();
	}
	
	public synchronized void stop() {
		if (!isRunning) {
			return;
		}
		
		this.isRunning = false;
	}
	
	public Game(String[] args) {
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
	
	//Game Loop method TODO: Go over this and make sure it is working properly
	public void beginGameLoop() {
		long beginTime = System.nanoTime();
		double tick = 60.0D;
		double ns = 1000000000 / tick;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int ticks = 0;
		int frames = 0;
		
		while (this.isRunning) {
			long currentTime = System.nanoTime();
			delta += (currentTime - beginTime) / ns;
			beginTime = currentTime;
			
			while (delta >= 1) {
				ticks++;
				tick();
				delta--;
			}
			
			frames++;
			this.render();
			
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				LoggingUtil.getLogger().log(Level.INFO, "Ticks: " + ticks + ", FPS: " + frames);
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	private void tick() {
		tickCount++;
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if (bs == null) {
			this.createBufferStrategy(2);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Grid grid = new Grid();
		grid.drawGridGraphics(g);
		
		g.dispose();
		bs.show();
		
	}
	
	@Override
	public void run() {
		LoggingUtil.getLogger().log(Level.INFO, "Game loop is starting");
		this.beginGameLoop();
	}
}