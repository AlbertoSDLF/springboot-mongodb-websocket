package com.asitc.sbmongodbwebsocket;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;

import reactor.core.publisher.Flux;

public interface HelloMessageRepository extends ReactiveMongoRepository<HelloMessage, String> {

	  @Tailable
	  Flux<HelloMessage> findBy();
	  @Tailable
	  Flux<HelloMessage> findByReceiver(String receiver);

}
