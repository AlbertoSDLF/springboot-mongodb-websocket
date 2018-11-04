package com.asitc.sbmongodbwebsocket;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class HelloMessageObserver {

	@Autowired
	private HelloMessageRepository repository;
	@Autowired
	private SimpMessagingTemplate webSocket;
	
	@PostConstruct
	public void init() {
		repository.findByName("Test!").doOnEach(hm -> this.webSocket.convertAndSend("/topic/greetings", 
				Greeting.getForHelloMessage(hm.get()))).subscribe();
	}
	
}
