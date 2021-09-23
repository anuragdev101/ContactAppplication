package com.evolent.contacts.delegates.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.evolent.contacts.services.interfaces.InactivateContactService;
import com.evolent.contacts.swagger.api.InactivateApiDelegate;

public class InactivateContactDelegateImpl implements InactivateApiDelegate {

	@Autowired
	private InactivateContactService inactivateContactService;

	public ResponseEntity<String> deleteContact(Long phone, String email) {

		try {
			inactivateContactService.execute(phone, email);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("Contact marked as inactive!");

	}

}
