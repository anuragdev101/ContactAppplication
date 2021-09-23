package com.evolent.contacts.mappers.implementation;

import javax.inject.Inject;
import javax.inject.Provider;

import com.evolent.contacts.mappers.interfaces.IMapContactToContactDto;
import com.evolent.contacts.persistence.beans.ContactDto;
import com.evolent.contacts.swagger.model.ContactInfo;

public class MapContactToContactDto implements IMapContactToContactDto{

	@Inject
	Provider<ContactDto> contactDtoProvider;

	@Override
	public ContactDto mapToDto(ContactInfo contact) {
		ContactDto contactDto = contactDtoProvider.get();
		contactDto.setFirstName(contact.getFirstName());
		contactDto.setLastName(contact.getLastName());
		contactDto.setEmail(contact.getEmail());
		contactDto.setPhone(contact.getPhone());
		contactDto.setStatus("Active");
		return contactDto;
	}

}
