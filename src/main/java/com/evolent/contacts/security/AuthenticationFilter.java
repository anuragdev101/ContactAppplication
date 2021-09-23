package com.evolent.contacts.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.evolent.contacts.persistence.beans.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
    private AuthenticationManager authenticationManager;
    
    private static String secretKey=System.getenv("secretKey");
    
    private static String jwtTokenTimeout=System.getenv("jwtTokenTimeout");

    public AuthenticationFilter(AuthenticationManager authenticationManager)
    {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
        	User creds = new ObjectMapper().readValue(request.getInputStream(), User.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(), creds.getPassword(), new ArrayList<>()));
        }
        catch(IOException e)
        {
            throw new RuntimeException("Could not read request" + e);
        }
    }
    
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authentication)
    {	
    	Keys.hmacShaKeyFor(secretKey.getBytes());
    	
        String token = Jwts.builder()
                .setSubject(((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + Integer.valueOf(jwtTokenTimeout))).signWith(Keys.hmacShaKeyFor(secretKey.getBytes()),SignatureAlgorithm.HS512)
                .compact();
        response.addHeader("Authorization","Bearer " + token);
    }
}
