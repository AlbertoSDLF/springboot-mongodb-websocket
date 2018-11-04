package com.asitc.sbmongodbwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class SbMongodbWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbMongodbWebsocketApplication.class, args);
    }
    
}
