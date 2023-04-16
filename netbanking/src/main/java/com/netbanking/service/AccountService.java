package com.netbanking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netbanking.dto.AccountDto;
import com.netbanking.entities.Account;
import com.netbanking.exception.AccountNotFoundException;
import com.netbanking.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Transactional(readOnly = true)
	public AccountDto findAccount(int accountId) {
		AccountDto accountDto = new AccountDto();
		Optional<Account> account = null;
		account = accountRepository.findById(accountId);

		account.ifPresentOrElse((accountA) -> {
			accountDto.setUserId(accountA.getUserId());
			accountDto.setAccountHolderName(accountA.getAccountHolderName());
			accountDto.setAccountType(accountA.getAccountType());
			accountDto.setIfscCode(accountA.getIfscCode());
			accountDto.setBalance(accountA.getBalance());
			accountDto.setAccountNo(accountA.getAccountNo());
		}, () -> {
			throw new AccountNotFoundException("account not found for the given id");
		});

		return accountDto;

	}

	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("welcome1"));
	}
}
