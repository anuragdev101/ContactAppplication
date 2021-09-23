package com.evolent.contacts.services.interfaces;

import org.springframework.http.ResponseEntity;

import com.evolent.contacts.swagger.model.ContactInfo;

public interface EditContactService {
	
	public void execute(ContactInfo  contact);

}
