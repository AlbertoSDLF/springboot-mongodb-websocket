package com.asitc.sbmongodbwebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
	
	@Autowired
	private HelloMessageRepository repository;
	@Autowired
	private SimpMessagingTemplate webSocket;

    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
    public void greeting(final HelloMessage message) {
    	repository.insert(message).doOnNext(System.out::println).doOnNext(
    			hm -> this.webSocket.convertAndSend("/topic/greetings/" + hm.getReceiver(), 
				Greeting.getForHelloMessage(hm))).subscribe();
    }

}
