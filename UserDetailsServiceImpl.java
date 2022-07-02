package com.komal.coupon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.komal.coupon.model.User;
import com.komal.coupon.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user=repo.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("Username not found for email: "+username);
		}
		return  new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles());
	}
}
