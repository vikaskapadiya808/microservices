package com.netbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netbanking.dto.AccountDto;
import com.netbanking.exception.AccountNotFoundException;
import com.netbanking.service.AccountService;
import com.netbanking.service.beans.UserDetailsImpl;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/find.htm")
	public String showFindAccount() {
		return "find-account";
	}

	@PostMapping("/find.htm")
	public String findAccount(@RequestParam("accountNo") String accountNo, Model model) {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();

		UserDetailsImpl userDetails = null;
		boolean isCustomerRole = false;

		isCustomerRole = authentication.getAuthorities().stream().anyMatch(role->role.getAuthority().equals("manager"));

		AccountDto accountDto = accountService.findAccount(Integer.parseInt(accountNo));
		if (isCustomerRole) {
			userDetails = (UserDetailsImpl) authentication.getPrincipal();
			if (userDetails.getAccountId() != accountDto.getUserId()) {
				throw new AccessDeniedException("cusotmer not authorized");
			}
		}

		model.addAttribute("account", accountDto);
		return "account-details";
	}

	@ExceptionHandler
	public String accountNotFoundException(AccountNotFoundException accountNotFoundException, Model model) {
		model.addAttribute("message", "error");
		return "account-error";
	}

}
