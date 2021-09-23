package com.evolent.contacts.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.evolent.contacts.persistence.beans.ContactDto;

public interface ContactRepository extends CrudRepository<ContactDto, String> {
	
	static final String ACTIVE = "Active";

	public ContactDto findByPhoneAndStatus(Long phone, String active);

	public ContactDto findByEmailAndStatus(String email, String active);

	public List<ContactDto> findByStatus(String active);
	
	public ContactDto findByPhoneAndEmailAndStatus(Long phone,String email,String active);

	default List<ContactDto> findAll() {
		return findByStatus(ACTIVE);
	}
	
	default ContactDto findByPhone(Long phone) {
		return findByPhoneAndStatus(phone,ACTIVE);
	}
	
	default ContactDto findByEmail(String email) {
		return findByEmailAndStatus(email,ACTIVE);
	}
	
	default ContactDto findByPhoneAndEmail(Long phone, String email) {
		return findByPhoneAndEmailAndStatus(phone,email,ACTIVE);
	}

}
