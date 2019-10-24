package com.ace.wrapper;

import org.springframework.stereotype.Component;

import com.ace.entity.Person;
import com.ace.entity.PersonPayload;
import com.ace.entity.UpdateMobilePayload;
import com.ace.dto.request.UpdateMobileRequest;

@Component
public class PersonWrapper {

	public Person fromPersonPayload(PersonPayload personPayload) {
		Person p = new Person();

		p.setFirstName(personPayload.getFirstName());
		p.setLastName(personPayload.getLastName());
		p.setMobile(personPayload.getMobile());
		p.setEmail(personPayload.getEmail());
		p.setAge(personPayload.getAge());
		return p;
	}

	public UpdateMobileRequest fromUpdateMobileRequest(UpdateMobilePayload UpdateMobilePayload) {
		UpdateMobileRequest request = new UpdateMobileRequest();
		request.setMobile(UpdateMobilePayload.getMobile());
		request.setPersonId(UpdateMobilePayload.getPersonId());
		return request;
	}

}
