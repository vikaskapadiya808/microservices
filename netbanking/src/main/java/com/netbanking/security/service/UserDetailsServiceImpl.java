package com.netbanking.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.netbanking.entities.User;
import com.netbanking.repository.UserRepository;
import com.netbanking.service.beans.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userEnity = null;
		UserDetails userDetails = null;
		Optional<User> user = null;

		user = userRepository.findByEmailAddress(username);
		userEnity = user.get();

		if (user.isPresent()) {

			userDetails = new UserDetailsImpl(userEnity.getUserId(), userEnity.getEmailAddress(),
					userEnity.getPassword(), userEnity.getStatus(), userEnity.getRole().getRoleName());
		} else {
			throw new UsernameNotFoundException("user not found for the given username");
		}

		return userDetails;
	}

}
