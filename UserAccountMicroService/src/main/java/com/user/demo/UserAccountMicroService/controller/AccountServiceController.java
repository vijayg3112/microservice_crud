package com.user.demo.UserAccountMicroService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.demo.UserAccountMicroService.AccserviceProxy;

@RestController
@RequestMapping("/democlient")
public class AccountServiceController {

	@Autowired
	AccserviceProxy proxy;


	@RequestMapping(value = "/alluserinfo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getAllUserInfo() {
		return proxy.retrieveUserInfo();

	}
}
