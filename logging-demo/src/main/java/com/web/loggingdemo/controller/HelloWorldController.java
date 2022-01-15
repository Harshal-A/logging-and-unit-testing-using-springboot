package com.web.loggingdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	

	private static final Logger LOGGER=LoggerFactory.getLogger(HelloWorldController.class);

	@GetMapping("/hello")
	public String sayHello() {
		LOGGER.info("1st info log");
		LOGGER.trace("1st trace log");
		LOGGER.warn("1st warn log");
		LOGGER.debug("1st debug log");
		return "Hello World";
	}
}
