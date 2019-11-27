package com.user.demo.Microservicecrud.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAccountdtls {

	@Id
	private long userId;
	private String accountNo;
	private String accountType;
	private String accountBalance;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}

}
