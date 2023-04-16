package com.paytmoauth2.dto;

public class MerchantPayResponse {
	private String transactionNo;
	private String merchantAccountNo;
	private String payTMAccountNo;
	private double amount;
	private String status;

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getMerchantAccountNo() {
		return merchantAccountNo;
	}

	public void setMerchantAccountNo(String merchantAccountNo) {
		this.merchantAccountNo = merchantAccountNo;
	}

	public String getPayTMAccountNo() {
		return payTMAccountNo;
	}

	public void setPayTMAccountNo(String payTMAccountNo) {
		this.payTMAccountNo = payTMAccountNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MerchantPayResponse [transactionNo=" + transactionNo + ", merchantAccountNo=" + merchantAccountNo
				+ ", payTMAccountNo=" + payTMAccountNo + ", amount=" + amount + ", status=" + status + "]";
	}

}
