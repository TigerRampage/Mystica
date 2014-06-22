package com.mystica.component;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.util.logging.Level;

import com.mystica.util.LoggingUtil;

public class Grid {
	
	public Grid() {
	}
	
	public Graphics drawGridGraphics(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		//Draws the rhombuses on the screen in a grid like fashion
		int rhombus_width = 40;
		int rhombus_height = 20;
		
		int[] x_points = {rhombus_width / 2, rhombus_width, rhombus_width / 2, 0, rhombus_width / 2};
		int[] y_points = {0, rhombus_height / 2, rhombus_height, rhombus_height / 2, 0};
		
		if (x_points.length != y_points.length) {
			LoggingUtil.getLogger().log(Level.SEVERE, "Grid cannot be drawn! The amount of x and y values are inequal!");
		}
		
		int SCALE_CONSTANT = 3;
		
		rhombus_width *= SCALE_CONSTANT;
		rhombus_height *= SCALE_CONSTANT;
		
		for (int i = 0; i < x_points.length; i++) {
			x_points[i] *= SCALE_CONSTANT;
			y_points[i] *= SCALE_CONSTANT;
		}
		
		for (int y = 0; y < 16; y++) {
			for (int x = 0; x < 16; x++) {
				
				GeneralPath gp = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x_points.length);
				
				int chunk_x = x_points[0] + x * rhombus_width;
				int chunk_y = y_points[0] + y * rhombus_height;
				
				gp.moveTo(chunk_x, chunk_y);
				
				for (int j = 1; j < x_points.length; j++) {
					/* Logs the coordinate points of the rhombus edges
					LoggingUtil.getLogger().log(Level.INFO, Integer.toString(x_points[j] + x * rhombus_width));
					*/
					gp.lineTo(x_points[j] + x * rhombus_width, y_points[j] + y * rhombus_height);
				}
				g2d.draw(gp);
			}
		}
		return (Graphics)g2d;
	}
}
