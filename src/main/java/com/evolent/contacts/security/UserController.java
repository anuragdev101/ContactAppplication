package com.evolent.contacts.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evolent.contacts.persistence.UserRepository;
import com.evolent.contacts.persistence.beans.User;

@RestController
@RequestMapping(value = "/users")
public class UserController
{
    private UserRepository userRepository;
    
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody User user)
    {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    
    @GetMapping("/ping")
    public String serverPing() {
    	return "Server is up!";
    }

}
