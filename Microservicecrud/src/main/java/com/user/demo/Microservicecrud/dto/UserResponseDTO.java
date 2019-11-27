package com.user.demo.Microservicecrud.dto;

public class UserResponseDTO extends BaseResponseDTO {

	private String accountno;

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	@Override
	public String toString() {
		return "UserResponseDTO [accountno=" + accountno + "]";
	}

}
