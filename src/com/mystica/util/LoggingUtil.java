package com.mystica.util;

import java.util.logging.Logger;

import com.mystica.component.GamePanel;

public class LoggingUtil {
	private static Logger logger = Logger.getLogger(GamePanel.class.getName());
	
	public static Logger getLogger() {
		return logger;
	}
}
