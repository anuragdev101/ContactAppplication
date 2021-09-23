package com.evolent.contacts.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.evolent.contacts.persistence.UserRepository;
import com.evolent.contacts.persistence.beans.User;

import java.util.Collections;

@Component
public class UserDetailsServiceImpl implements UserDetailsService
{
	
	@Autowired
	private UserRepository userRepo;
	
    @Override
    public UserDetails loadUserByUsername(String username)
    {	
    	User user = userRepo.findByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}