package com.evolent.contacts.services.implementation;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import com.evolent.contacts.mappers.interfaces.IMapContactDtoToContact;
import com.evolent.contacts.persistence.ContactRepository;
import com.evolent.contacts.persistence.beans.ContactDto;
import com.evolent.contacts.services.interfaces.ListContactService;
import com.evolent.contacts.swagger.model.ContactInfo;
import com.evolent.contacts.swagger.model.ContactsInfo;

public class ListContactServiceImpl implements ListContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Inject
	private IMapContactDtoToContact mapper;
	
	@Override
	public ContactsInfo execute() {
		List<ContactDto> contactsList = contactRepository.findAll();
		ContactsInfo contactsInfo = new ContactsInfo();
		for(ContactDto elem: contactsList) {
			ContactInfo contact = mapper.mapToDto(elem);
			contactsInfo.add(contact);
		}
		return contactsInfo;
	}
	
}
