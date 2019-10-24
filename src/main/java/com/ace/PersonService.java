package com.ace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import com.ace.Repository.PersonRepository;
import com.ace.entity.PersonPayload;
import com.ace.entity.UpdateMobilePayload;
import com.ace.wrapper.PersonWrapper;
@Component
public class PersonService {
	
	
	private final PersonStreams personStreams;

	public PersonService(PersonStreams personStreams) {
		super();
		this.personStreams = personStreams;
	}
	
	
	//Producer
	public void publishNewPersonRecord(final PersonPayload personPayload) {
		MessageChannel messageChannel =    personStreams.outboundPerson();
		messageChannel.send(MessageBuilder
                .withPayload(personPayload)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
	}
	
	//Producer
		public void publishUpdateMobileRecord(final UpdateMobilePayload personPayload) {
			MessageChannel messageChannel =    personStreams.outboundPersonUpdate();
			messageChannel.send(MessageBuilder
	                .withPayload(personPayload)
	                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
	                .build());
		}

}
