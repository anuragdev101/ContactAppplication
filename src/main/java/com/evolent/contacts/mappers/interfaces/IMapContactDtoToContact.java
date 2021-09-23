package com.evolent.contacts.mappers.interfaces;

import com.evolent.contacts.persistence.beans.ContactDto;
import com.evolent.contacts.swagger.model.ContactInfo;

public interface IMapContactDtoToContact {

	ContactInfo mapToDto(ContactDto contactDto);

}
