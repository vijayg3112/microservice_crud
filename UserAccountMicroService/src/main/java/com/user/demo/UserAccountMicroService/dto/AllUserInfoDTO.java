package com.user.demo.UserAccountMicroService.dto;

import java.util.List;

public class AllUserInfoDTO {

	List<Userdtls> userInfolist;

	int total_avl_balance;

	public List<Userdtls> getUserInfolist() {
		return userInfolist;
	}

	public void setUserInfolist(List<Userdtls> userInfolist) {
		this.userInfolist = userInfolist;
	}

	public int getTotal_avl_balance() {
		return total_avl_balance;
	}

	public void setTotal_avl_balance(int total_avl_balance) {
		this.total_avl_balance = total_avl_balance;
	}

	

}
