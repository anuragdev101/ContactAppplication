package com.evolent.contacts.delegates.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.evolent.contacts.services.interfaces.AddContactService;
import com.evolent.contacts.swagger.api.AddApiDelegate;
import com.evolent.contacts.swagger.model.ContactInfo;

public class AddContactDelegateImpl implements AddApiDelegate {

	@Autowired
	private AddContactService addContactService;

	public ResponseEntity<String> addContact(ContactInfo contact) {
		
		try {
			addContactService.execute(contact);
		} catch (Exception e) {
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("Contact created successfully!");
	}

}
