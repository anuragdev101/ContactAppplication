package com.evolent.contacts.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.evolent.contacts.persistence.ContactRepository;
import com.evolent.contacts.persistence.beans.ContactDto;
import com.evolent.contacts.services.interfaces.EditContactService;
import com.evolent.contacts.swagger.model.ContactInfo;

public class EditContactServiceImpl implements EditContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public void execute(ContactInfo  contact) {
		if(contact.getEmail() != null && contact.getPhone() != null) {
			throw new RuntimeException("Either provide only email or phone number in contact information or use the deactivate the contact service");
			//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Either provide only email or phone number in contact information or use the deactivate the contact service");
		}
		ContactDto contactDto = null;
		if(contact.getEmail() != null) {
			contactDto = contactRepository.findByEmail(contact.getEmail());
		}
		else if(contact.getPhone() != null) {
			contactDto = contactRepository.findByPhone(contact.getPhone());
		}
		else {
			throw new RuntimeException("Provide email or phone number in contact information");
			//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Provide email or phone number in contact information");
		}
		if(contactDto != null) {
			modifyContactDto(contactDto, contact);
			contactRepository.save(contactDto);
			//return ResponseEntity.status(HttpStatus.OK).body("Contact details updated!");
		}
		else {
			throw new RuntimeException("No contact exists with the given email or phone number!");
			//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No contact exists with the given email or phone number!");
		}
	}
	
	private void modifyContactDto(ContactDto contactDto, ContactInfo contact) {

		if(contact.getFirstName() != null) {
			contactDto.setFirstName(contact.getFirstName());
		}
		if(contact.getLastName() != null) {
			contactDto.setLastName(contact.getLastName());
		}
		if(contact.getEmail() != null) {
			contactDto.setEmail(contact.getEmail());
		}
		if(contact.getPhone() != null) {
			contactDto.setPhone(contact.getPhone());
		}
	}
	
}
