package com.user.demo.Microservicecrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.demo.Microservicecrud.dao.UserDAO;
import com.user.demo.Microservicecrud.dto.AllUserInfoDTO;
import com.user.demo.Microservicecrud.dto.BaseResponseDTO;
import com.user.demo.Microservicecrud.dto.UserInfoResponseDTO;
import com.user.demo.Microservicecrud.dto.UserRequestDTO;
import com.user.demo.Microservicecrud.entity.Userdtls;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userdao;

	public BaseResponseDTO createNewAccountHolder(UserRequestDTO user) {
		BaseResponseDTO response = new BaseResponseDTO();
		Userdtls userdtls = new Userdtls();

		userdtls.setFirstName(user.getFirstName());
		userdtls.setLastName(user.getLastName());
		userdtls.setEmailId(user.getEmailId());
		userdtls.setPhoneNumber(user.getPhoneNumber());
		userdtls.setAddress(user.getAddress());

		boolean addNewUserAccount = userdao.AddNewUserAccount(userdtls);
		if (addNewUserAccount) {

			response.setresponseCode("00");
			response.setStatus("Success");

		} else {
			response.setresponseCode("01");
			response.setStatus("Failed");
		}

		return response;
	}

	@Override
	public Object getUserDetails(String userId) {

		Userdtls userdtls = userdao.getUserInfo(userId);

		if (userdtls != null) {
			UserInfoResponseDTO response = new UserInfoResponseDTO();
			response.setAddress(userdtls.getAddress());
			response.setEmailId(userdtls.getEmailId());
			response.setFirstName(userdtls.getFirstName());
			response.setLastName(userdtls.getLastName());
			response.setPhoneNumber(userdtls.getPhoneNumber());
			response.setUserId(userdtls.getUserId());
			return response;
		} /*
			 * else {
			 * 
			 * BaseResponseDTO response = new BaseResponseDTO();
			 * response.setresponseCode("01");
			 * response.setStatus("Failed, No Record Found"); return response; }
			 */
		return userdtls;

	}

	@Override
	public BaseResponseDTO updateUserInfo(String id, UserRequestDTO userreqsto) {

		Userdtls userdtls = new Userdtls();
		BaseResponseDTO response = new BaseResponseDTO();

		userdtls.setAddress(userreqsto.getAddress());
		userdtls.setEmailId(userreqsto.getEmailId());
		userdtls.setFirstName(userreqsto.getFirstName());
		userdtls.setLastName(userreqsto.getLastName());
		userdtls.setPhoneNumber(userreqsto.getPhoneNumber());

		boolean isuserdtlsupdated = userdao.updateUserDetailsById(id, userdtls);
		if (isuserdtlsupdated) {

			response.setresponseCode("00");
			response.setStatus("Success");
			return response;
		} else {
			return null;
		}

	}

	@Override
	public Object deleteUserDetails(String id) {
		// TODO Auto-generated method stub
		BaseResponseDTO response = new BaseResponseDTO();
		boolean isDeleted = userdao.deleteUserInfo(id);

		if (isDeleted) {

			response.setresponseCode("00");
			response.setStatus("Success");
			return response;
		} else {
			return null;
		}

	}

	@Override
	public AllUserInfoDTO getAllUserInfo() {

		AllUserInfoDTO dto = userdao.getallUserInfo();
		return dto;
	}

}
