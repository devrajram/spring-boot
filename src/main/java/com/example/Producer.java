package com.example;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;

	
	public void run(String... args) throws Exception {
		send("*****Hi. This is Devraj");
		System.out.println("First Message was sent to the Queue: " + queue.getQueueName());
		
		Thread.sleep(200);
		
		send("******How are you doing?");
		System.out.println("Second Message was sent to the Queue: " + queue.getQueueName());
		
		
	}

	public void send(String msg) {
		this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
	}

}