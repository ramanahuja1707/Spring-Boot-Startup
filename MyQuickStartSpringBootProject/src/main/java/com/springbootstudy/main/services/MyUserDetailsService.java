package com.springbootstudy.main.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbootstudy.main.model.MyUserDetails;
import com.springbootstudy.main.model.entities.UserEntity;
import com.springbootstudy.main.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> user = userRepository.findUserByUsername(username);
		MyUserDetails userDetails = new MyUserDetails();
		BeanUtils.copyProperties(user.get(), userDetails);
		return userDetails;
	}

}
