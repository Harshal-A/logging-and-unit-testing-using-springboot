package com.web.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class Foo 
{

    	static final Logger logger = LoggerFactory.getLogger(Foo.class);
    	  
    	  public void doIt() {
    	    logger.debug("Did it again!");
}
}
