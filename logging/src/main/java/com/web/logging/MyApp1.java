package com.web.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class MyApp1 {

	 final static Logger logger = LoggerFactory.getLogger(MyApp1.class);

	  public static void main(String[] args) {
	    logger.info("Entering application.");

	    Foo foo = new Foo();
	    foo.doIt();
	    logger.info("Exiting application.");
//	    LoggerContext lc=(LoggerContext) LoggerFactory.getILoggerFactory();
//	    StatusPrinter.print(lc);
	  }
}
