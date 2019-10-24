package com.ace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ace.dto.request.UpdateMobileRequest;
import com.ace.entity.PersonPayload;
import com.ace.entity.UpdateMobilePayload;
import com.ace.service.PersonServiceImpl;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {


private final PersonServiceImpl personService;

@Autowired
public KafkaController(PersonServiceImpl personService) {
this.personService=personService;
}
	

@PostMapping(value = "/publish/person",consumes=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Object> publishNewPersonRecord(@RequestBody PersonPayload personPayload){
this.personService.publishNewPersonRecord(personPayload);

return new ResponseEntity<Object>(HttpStatus.OK);
}


//publish update record
@PostMapping (value = "/publish/update-person",consumes=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Object> publishUpdateMobileRecord(@RequestBody UpdateMobilePayload updateMobilePayload){
this.personService.publishUpdateMobileRecord(updateMobilePayload);

return new ResponseEntity<Object>(HttpStatus.OK);
}

}
