package com.evolent.contacts.delegates.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.evolent.contacts.services.interfaces.EditContactService;
import com.evolent.contacts.swagger.api.EditApiDelegate;
import com.evolent.contacts.swagger.model.ContactInfo;

public class EditContactDataDelegateImpl implements EditApiDelegate{
	
	@Autowired
	private EditContactService editContactService;
	
	public ResponseEntity<String> editExistingContact( ContactInfo  contact) {
		try {
			editContactService.execute(contact);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("Contact details updated!");
	}

}
