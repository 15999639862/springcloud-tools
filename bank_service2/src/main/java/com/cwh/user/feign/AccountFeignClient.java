package com.cwh.user.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "BANK-SERVICE1",fallback = AccountFallback.class)
@RequestMapping(value = "/bank-service1")
public interface AccountFeignClient {
	
	@PostMapping("/addAmount")
    int addAmount(@RequestBody Map<String,Object> map);


}
