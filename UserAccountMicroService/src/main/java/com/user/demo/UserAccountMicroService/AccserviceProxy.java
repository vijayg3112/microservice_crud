package com.user.demo.UserAccountMicroService;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "UserInfoService")
@RibbonClient(name = "UserInfoService")
public interface AccserviceProxy {

	@GetMapping("/demo/getalluserinfo")
	public ResponseEntity<Object> retrieveUserInfo();

}