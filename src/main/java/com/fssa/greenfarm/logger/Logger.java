package com.fssa.greenfarm.logger;

public class Logger {
	  // Private constructor to prevent instantiation from outside the class
    private Logger() {

    }
    
     public static void info(Object obj) {
    	 System.out.println(obj);
     }
} 
