package com.paytmoauth2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MerchantPayRequest {

	@JsonProperty("merchant_account")
	private String merchantAccountNo;
	@JsonProperty("paytm_account")
	private String payTMAccountNumber;

	private double amount;
	private String description;

	public String getMerchantAccountNo() {
		return merchantAccountNo;
	}

	public void setMerchantAccountNo(String merchantAccountNo) {
		this.merchantAccountNo = merchantAccountNo;
	}

	public String getPayTMAccountNumber() {
		return payTMAccountNumber;
	}

	public void setPayTMAccountNumber(String payTMAccountNumber) {
		this.payTMAccountNumber = payTMAccountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MerchantPayRequest [merchantAccountNo=" + merchantAccountNo + ", payTMAccountNumber="
				+ payTMAccountNumber + ", amount=" + amount + ", description=" + description + "]";
	}

}
