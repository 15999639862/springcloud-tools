package com.cwh.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cwh.user.service.AccountAddService;

@RestController
public class AccountAddController {

	@Autowired
	private AccountAddService accountAddService;
	
	@RequestMapping("/addAmount")
	@ResponseBody
	public long addAmount(@RequestParam("amount") double amount) {
		long start = System.currentTimeMillis();
		Map<String,Object> map =  new HashMap<>();
		map.put("amount", amount);
		map.put("accountNo", "2");
		accountAddService.addAmount(map);
		long end = System.currentTimeMillis();
		return end - start;
	}
	
	
}
