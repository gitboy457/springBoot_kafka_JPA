package com.ace.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import com.ace.dto.request.UpdateMobileRequest;
import com.ace.entity.PersonPayload;
import com.ace.entity.UpdateMobilePayload;

public interface PersonService {
	public void publishNewPersonRecord(final PersonPayload personPayload);
	public void publishUpdateMobileRecord(final UpdateMobilePayload personPayload);
	
}
