package com.logging.controller;

import java.util.logging.Logger;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paytm")
public class PaytmController {
	Logger logger = java.util.logging.Logger.getLogger(PaytmController.class.getName());

	@GetMapping(value = "/balance/{mobileNo}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getBalance(@PathVariable("mobileNo") long mobileNo) {
		logger.info("recieved mobile : "+mobileNo);
		return "Balance is :" + mobileNo;
	}

}
