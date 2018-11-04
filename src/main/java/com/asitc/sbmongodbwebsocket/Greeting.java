package com.asitc.sbmongodbwebsocket;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.util.HtmlUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {

    private String content;
    
    public static Greeting getForHelloMessage(final HelloMessage message) {
    	return new Greeting(String.format("Hello, %s!", HtmlUtils.htmlEscape(message.getName())));
    }

}
