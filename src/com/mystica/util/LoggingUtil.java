package com.mystica.util;
import java.util.logging.Logger;

import com.mystica.launch.Game;

public class LoggingUtil {
	
	private static Logger logger = Logger.getLogger(Game.class.getName());
	
	public static Logger getLogger() {
		return logger;
	}
}
