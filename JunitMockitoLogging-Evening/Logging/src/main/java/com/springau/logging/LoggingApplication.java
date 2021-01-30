package com.springau.logging;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggingApplication {

	private static Logger logger = Logger.getLogger(LoggingApplication.class);


	public static void main(String[] args) {
		 BasicConfigurator.configure();
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Logger has been Initialize");
	        System.out.println("Enter the Logger Level");
	        System.out.println("Menu");
	        System.out.println("1. All");
	        System.out.println("2. Debug");
	        System.out.println("3. Infor");
	        System.out.println("4. Warn");
	        System.out.println("5. Error");
	        System.out.println("6. Fatal");
	        System.out.println("7. none");
	        System.out.println("Enter your choice: \t");
	        int ch = sc.nextInt();
	        switch (ch) {
	            case 1:
	                logger.setLevel(Level.ALL);
	                break;
	            case 2:
	                logger.setLevel(Level.DEBUG);
	                break;
	            case 3:
	                logger.setLevel(Level.INFO);
	                break;
	            case 4:
	                logger.setLevel(Level.WARN);
	                break;
	            case 5:
	                logger.setLevel(Level.ERROR);
	                break;
	            case 6:
	                logger.setLevel(Level.FATAL);
	                break;
	            case 7:
	                logger.setLevel(Level.OFF);
	                break;
	        }
	        logger.trace("Trace Message!");
	        logger.debug("Debug Message!");
	        logger.info("Info Message!");
	        logger.warn("Warn Message!");
	        logger.error("Error Message!");
	        logger.fatal("Fatal Message!");	}

}
