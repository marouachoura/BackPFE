package com.example.demo.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmployeRepository;
import com.example.demo.entities.Employe;
//import com.example.demo.security.models.User;
//import com.example.demo.security.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	/*@Autowired
	UserRepository userRepository;*/
	@Autowired
	EmployeRepository userRepository ;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/*User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		return UserDetailsImpl.build(user);*/
		
		
		Employe emp = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException(" User Not Found with username"+username)) ;
		return UserDetailsImpl.build(emp);
	}
	
}