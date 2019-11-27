package com.user.demo.Microservicecrud.dao;

import com.user.demo.Microservicecrud.dto.AllUserInfoDTO;
import com.user.demo.Microservicecrud.entity.Userdtls;

public interface UserDAO {

	
	public boolean AddNewUserAccount(Userdtls userdetails);
	
	public Userdtls getUserInfo(String userId);
	
	public boolean  updateUserDetailsById(String userId,Userdtls userdetails);
	
	public boolean  deleteUserInfo(String userId);
	
	
	public AllUserInfoDTO  getallUserInfo();
	
	
}
