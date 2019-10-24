package com.ace;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PersonStreams {
	String INPUT_PERSON = "person-in";
	String OUTPUT_PERSON = "person-out";
	String INPUT_PERSON_UPDATE="personUpdate-in";
	String OUTPUT_PERSON_UPDATE="personUpdate-out";
	

	@Input(INPUT_PERSON)
	SubscribableChannel inboundPerson();

	@Output(OUTPUT_PERSON)
	MessageChannel outboundPerson();
	
	
	@Input(INPUT_PERSON_UPDATE)
	SubscribableChannel inboundPersonUpdate();

	@Output(OUTPUT_PERSON_UPDATE)
	MessageChannel outboundPersonUpdate();
}
