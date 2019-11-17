package com.cwh.score.feign;

import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "BANK-SERVICE2",fallback = AccountAddFallback.class)
@RequestMapping("/bank-service2")
public interface AccountAddFeignClient {
	
	@RequestMapping("/addAmount")
	@Hmily
    long addAmount(@RequestParam("amount") double amount);


}
