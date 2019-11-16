package com.cwh.score.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cwh.score.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping("transfer")
	@ResponseBody
	public void transfer(String accountNo,double amount) {
		Map<String,Object> map = new HashMap<>();
		map.put("accountNo", accountNo);
		map.put("amount", amount);
		accountService.transfer(map);
	}
	
}
