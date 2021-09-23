package com.evolent.contacts.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.evolent.contacts.persistence.ContactRepository;
import com.evolent.contacts.persistence.beans.ContactDto;
import com.evolent.contacts.services.interfaces.EditContactService;
import com.evolent.contacts.services.interfaces.InactivateContactService;
import com.evolent.contacts.swagger.model.ContactInfo;

public class InactivateContactServiceImpl implements InactivateContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public void execute(Long phone, String email) {
		ContactDto contact;
		if(phone != null && email != null) {
			contact = contactRepository.findByPhoneAndEmail(phone, email);
		}
		else if(phone != null) {
			contact = contactRepository.findByPhone(phone);
		}
		else {
			contact = contactRepository.findByEmail(email);
		}
		if(contact != null) {
			contact.setStatus("Inactive");
		}
		else {
			throw new RuntimeException("No Contact found!");
		}
		contactRepository.save(contact);
	}
	
}
