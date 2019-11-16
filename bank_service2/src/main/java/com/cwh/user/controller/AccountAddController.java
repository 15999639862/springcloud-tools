package com.cwh.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cwh.user.service.AccountAddService;

@RestController
public class AccountAddController {

	@Autowired
	private AccountAddService accountAddService;
	
	@PostMapping("addAmount")
	@ResponseBody
	public void addAmount(@RequestBody Map<String,Object> map) {
		map.put("account", "2");
		accountAddService.addAmount(map);
	}
	
	
}
