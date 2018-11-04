package com.asitc.sbmongodbwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
	
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(final HelloMessage message) {
        return Greeting.getForHelloMessage(message);
    }

}
