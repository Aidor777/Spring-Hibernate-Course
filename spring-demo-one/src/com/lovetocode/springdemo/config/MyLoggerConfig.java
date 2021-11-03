package com.lovetocode.springdemo.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/** Logging config to be able to display Spring init logs to the console */
public class MyLoggerConfig {

    private String rootLoggerLevel;

    private String printLoggerLevel;

    public void setRootLoggerLevel(String rootLoggerLevel) {
        this.rootLoggerLevel = rootLoggerLevel;
    }

    public void setPrintLoggerLevel(String printLoggerLevel) {
        this.printLoggerLevel = printLoggerLevel;
    }

    public void initLogger() {
        // Parser logger levels
        Level rootLevel = Level.parse(this.rootLoggerLevel);
        Level printLevel = Level.parse(this.printLoggerLevel);

        // Get the application context logger
        Logger applicationContextLogger = Logger.getLogger(ClassPathXmlApplicationContext.class.getName());

        // Get its parent logger to set root logging level
        Logger parentLogger = applicationContextLogger.getParent();
        parentLogger.setLevel(rootLevel);

        // Set up the console handler
        var consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(printLevel);
        consoleHandler.setFormatter(new SimpleFormatter());

        // Add handler to the parent logger
        parentLogger.addHandler(consoleHandler);
    }
}
