package com.evolent.contacts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.evolent.contacts.delegates.implementation.AddContactDelegateImpl;
import com.evolent.contacts.delegates.implementation.EditContactDataDelegateImpl;
import com.evolent.contacts.delegates.implementation.InactivateContactDelegateImpl;
import com.evolent.contacts.delegates.implementation.ListApiDelegateImpl;
import com.evolent.contacts.persistence.beans.ContactDto;
import com.evolent.contacts.services.implementation.AddContactServiceImpl;
import com.evolent.contacts.services.implementation.EditContactServiceImpl;
import com.evolent.contacts.services.implementation.InactivateContactServiceImpl;
import com.evolent.contacts.services.implementation.ListContactServiceImpl;
import com.evolent.contacts.services.interfaces.AddContactService;
import com.evolent.contacts.services.interfaces.EditContactService;
import com.evolent.contacts.services.interfaces.InactivateContactService;
import com.evolent.contacts.services.interfaces.ListContactService;
import com.evolent.contacts.swagger.api.AddApiDelegate;
import com.evolent.contacts.swagger.api.EditApiDelegate;
import com.evolent.contacts.swagger.api.InactivateApiDelegate;
import com.evolent.contacts.swagger.api.ListApiDelegate;
import com.evolent.contacts.swagger.model.ContactInfo;

@Configuration
public class BeanDefinitions {

	@Bean
	public ListApiDelegate listApiImpl() {
		return new ListApiDelegateImpl();
	}

	@Bean
	public AddApiDelegate addContact() {
		return new AddContactDelegateImpl();
	}
	
	@Bean
	public EditApiDelegate editContact() {
		return new EditContactDataDelegateImpl();
	}
	
	@Bean
	public InactivateApiDelegate inactivateContact() {
		return new InactivateContactDelegateImpl();
	}
	
	@Bean
	public EditContactService editContactService() {
		return new EditContactServiceImpl();
	}
	
	@Bean
	public ListContactService listContactService() {
		return new ListContactServiceImpl();
	}
	
	@Bean
	public InactivateContactService inactivateContactService() {
		return new InactivateContactServiceImpl();
	}
	
	@Bean
	public AddContactService addContactService() {
		return new AddContactServiceImpl();
	}
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	@Scope("prototype")
	public ContactDto contactDto() {
		return new ContactDto();
	}
	
	@Bean
	@Scope("prototype")
	public ContactInfo contactInfo() {
		return new ContactInfo();
	}

}
