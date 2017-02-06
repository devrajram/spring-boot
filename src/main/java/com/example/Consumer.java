package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private String destinationQueue;
	
	@JmsListener(destination="${jms.queue.destination}")
	public void receive(String text) {
		logger.debug("Listening to queue: " + destinationQueue);
		
		logger.info("Message Received: " + text);
	}

}
