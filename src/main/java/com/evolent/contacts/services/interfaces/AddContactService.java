package com.evolent.contacts.services.interfaces;

import com.evolent.contacts.swagger.model.ContactInfo;

public interface AddContactService {
	
	public void execute(ContactInfo contact);

}
