package com.paytmoauth2.api;

import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paytmoauth2.dto.MerchantPayRequest;
import com.paytmoauth2.dto.MerchantPayResponse;

@RestController
@RequestMapping("/api/wallet")
public class PaytmWalletRestController {

	@PostMapping(value = "/payment", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public MerchantPayResponse addToWallet(@RequestBody MerchantPayRequest merchantPayRequest) {
System.out.println(merchantPayRequest);
		MerchantPayResponse merchantPayResponse = null;
		merchantPayResponse = new MerchantPayResponse();
		merchantPayResponse.setTransactionNo(UUID.randomUUID().toString());
		merchantPayResponse.setMerchantAccountNo(merchantPayRequest.getMerchantAccountNo());
		merchantPayResponse.setPayTMAccountNo(merchantPayRequest.getPayTMAccountNumber());
		merchantPayResponse.setAmount(merchantPayRequest.getAmount());
		merchantPayResponse.setStatus("ACTIVE");

		return merchantPayResponse;
	}

}
