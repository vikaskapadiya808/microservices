package com.netbanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netbanking.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
