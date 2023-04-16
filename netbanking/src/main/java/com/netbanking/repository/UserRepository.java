package com.netbanking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netbanking.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmailAddress(String emailAddress);
	
}
