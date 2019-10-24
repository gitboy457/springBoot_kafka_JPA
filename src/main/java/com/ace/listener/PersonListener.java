package com.ace.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ace.PersonStreams;
import com.ace.Repository.PersonRepository;
import com.ace.dto.request.UpdateMobileRequest;
import com.ace.entity.Person;
import com.ace.entity.PersonPayload;
import com.ace.entity.UpdateMobilePayload;
import com.ace.wrapper.PersonWrapper;

@Component
@EnableBinding(PersonStreams.class)
public class PersonListener {
	@Autowired
	private PersonRepository personRepositor;
	
	@Autowired
	private PersonWrapper personWrapper;
	//insert new record after consumeing from stream
	@StreamListener(PersonStreams.INPUT_PERSON)
    public void HandlePerson(@Payload PersonPayload personPayload) {
	Person person=	personWrapper.fromPersonPayload(personPayload);
	personRepositor.save(person);
        System.out.println(personPayload);
    }

	//update record after consumeing from stream
	@StreamListener(PersonStreams.INPUT_PERSON_UPDATE)
    public void UpdatePerson(@Payload UpdateMobilePayload UpdateMobilePayload) {
	UpdateMobileRequest request=personWrapper.fromUpdateMobileRequest(UpdateMobilePayload);
	personRepositor.updateMobile(request.getPersonId(), request.getMobile());
        System.out.println(UpdateMobilePayload);
    }
}
