package com.evolent.contacts.services.implementation;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.evolent.contacts.mappers.interfaces.IMapContactToContactDto;
import com.evolent.contacts.persistence.ContactRepository;
import com.evolent.contacts.persistence.beans.ContactDto;
import com.evolent.contacts.services.interfaces.AddContactService;
import com.evolent.contacts.swagger.model.ContactInfo;

public class AddContactServiceImpl implements AddContactService{
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Inject
	private IMapContactToContactDto mapper;

	@Override
	public void execute(ContactInfo contact) {
		
		ContactDto contactDto = mapper.mapToDto(contact);
		contactRepository.save(contactDto);
	}

}
