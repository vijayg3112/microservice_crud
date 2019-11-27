package com.user.demo.Microservicecrud.service;

import com.user.demo.Microservicecrud.dto.AllUserInfoDTO;
import com.user.demo.Microservicecrud.dto.BaseResponseDTO;
import com.user.demo.Microservicecrud.dto.UserRequestDTO;

public interface UserService {
	
	public BaseResponseDTO createNewAccountHolder(UserRequestDTO user);
	public Object  getUserDetails(String id);
	public BaseResponseDTO  updateUserInfo(String id,UserRequestDTO userreqsto);
	public Object  deleteUserDetails(String id);
	public AllUserInfoDTO  getAllUserInfo();
	
}
