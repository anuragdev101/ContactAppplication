package com.evolent.contacts.delegates.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.evolent.contacts.services.interfaces.ListContactService;
import com.evolent.contacts.swagger.api.ListApiDelegate;
import com.evolent.contacts.swagger.model.ContactsInfo;

public class ListApiDelegateImpl implements ListApiDelegate {

	@Autowired
	private ListContactService listContactSvc;

	public ResponseEntity<ContactsInfo> fetchAllContacts() {
		ContactsInfo contactsInfo = listContactSvc.execute();
		return ResponseEntity.status(HttpStatus.OK).body(contactsInfo);

	}
}
