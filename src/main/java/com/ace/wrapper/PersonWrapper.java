package com.ace.wrapper;

import org.springframework.stereotype.Component;

import com.ace.entity.Person;
import com.ace.entity.PersonPayload;
import com.ace.entity.UpdateMobilePayload;
import com.ace.dto.request.PersonRequest;
import com.ace.dto.request.UpdateMobileRequest;

@Component
public class PersonWrapper {

	public Person fromPersonRequest(PersonRequest request) {
		Person p = new Person();

		p.setFirstName(request.getFirstName());
		p.setLastName(request.getLastName());
		p.setMobile(request.getMobile());
		p.setEmail(request.getEmail());
		p.setAge(request.getAge());
		return p;
	}

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
