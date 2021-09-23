package com.evolent.contacts.persistence;

import org.springframework.data.repository.CrudRepository;

import com.evolent.contacts.persistence.beans.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByUsername(String username);

}
