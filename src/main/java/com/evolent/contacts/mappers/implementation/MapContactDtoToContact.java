package com.evolent.contacts.mappers.implementation;

import javax.inject.Inject;
import javax.inject.Provider;

import com.evolent.contacts.mappers.interfaces.IMapContactDtoToContact;
import com.evolent.contacts.persistence.beans.ContactDto;
import com.evolent.contacts.swagger.model.ContactInfo;

public class MapContactDtoToContact implements IMapContactDtoToContact{

	@Inject
	Provider<ContactInfo> contactProvider;

	@Override
	public ContactInfo mapToDto(ContactDto contactDto) {
		ContactInfo contact = contactProvider.get();
		contact.setId(String.valueOf(contactDto.getId()));
		contact.setFirstName(contactDto.getFirstName());
		contact.setLastName(contactDto.getLastName());
		contact.setEmail(contactDto.getEmail());
		contact.setPhone(contactDto.getPhone());
		return contact;
	}

}
