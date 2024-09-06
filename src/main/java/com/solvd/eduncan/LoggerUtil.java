package com.solvd.eduncan;

import java.io.IOException;
import java.util.logging.*;

public class LoggerUtil {
    private static final Logger LOGGER = Logger.getLogger(LoggerUtil.class.getName());

    static {
        try {
            // Console handler
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.ALL);
            LOGGER.addHandler(consoleHandler);

            // File handler
            FileHandler fileHandler = new FileHandler("application.log", true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);

            LOGGER.setLevel(Level.ALL);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error setting up logger", e);
        }
    }

    public static void log(Level level, String message) {
        LOGGER.log(level, message);
    }
}

