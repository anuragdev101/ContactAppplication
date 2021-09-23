package com.evolent.contacts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.evolent.contacts.mappers.implementation.MapContactDtoToContact;
import com.evolent.contacts.mappers.implementation.MapContactToContactDto;
import com.evolent.contacts.mappers.interfaces.IMapContactDtoToContact;
import com.evolent.contacts.mappers.interfaces.IMapContactToContactDto;

@Configuration
public class MapperDefinitions {
	
	@Bean
	public IMapContactToContactDto mapContactToContactDto() {
		return new MapContactToContactDto();
	}
	
	@Bean
	public IMapContactDtoToContact mapContactDtoToContact() {
		return new MapContactDtoToContact();
	}

}
