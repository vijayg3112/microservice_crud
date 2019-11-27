package com.user.demo.Microservicecrud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.demo.Microservicecrud.Exception.RecordNotFoundException;
import com.user.demo.Microservicecrud.dto.AllUserInfoDTO;
import com.user.demo.Microservicecrud.dto.BaseResponseDTO;
import com.user.demo.Microservicecrud.dto.UserRequestDTO;
import com.user.demo.Microservicecrud.service.UserService;

@RestController
@RequestMapping("/demo")
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping(value = "/addNewUserAccount", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> addCustomer(@RequestHeader HttpHeaders httpHeader,
			@Valid @RequestBody UserRequestDTO userdto) {

		BaseResponseDTO response = service.createNewAccountHolder(userdto);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/getUserInfo/{userId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getUserAccountDetails(@PathVariable String userId) {
		Object responsedto = service.getUserDetails(userId);

		if (responsedto == null) {
			throw new RecordNotFoundException("Invalid User id : " + userId);
		}
		return new ResponseEntity<Object>(responsedto, HttpStatus.OK);

	}

	@RequestMapping(value = "/updateUserInfo/{userId}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> updateUserDetails(@PathVariable String userId,
			@Valid @RequestBody UserRequestDTO userdto) {
		BaseResponseDTO responsedto = service.updateUserInfo(userId, userdto);
		if (responsedto == null) {
			throw new RecordNotFoundException("Invalid User id : " + userId);
		}
		return new ResponseEntity<Object>(responsedto, HttpStatus.OK);

	}

	@RequestMapping(value = "/deleteUserInfo/{userId}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Object> deleteUserDetails(@PathVariable String userId) {
		Object responsedto = service.deleteUserDetails(userId);
		if (responsedto == null) {
			throw new RecordNotFoundException("Invalid User id : " + userId);
		}
		return new ResponseEntity<>(responsedto, HttpStatus.OK);

	}

	@RequestMapping(value = "/getalluserinfo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getAllUserInfo() {
		AllUserInfoDTO allUserInfo = service.getAllUserInfo();
		if (allUserInfo == null) {
			throw new RecordNotFoundException("UserData Not Found");
		}
		return new ResponseEntity<>(allUserInfo, HttpStatus.OK);

	}

}
