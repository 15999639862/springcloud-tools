package com.cwh.score.feign;

import java.util.Map;

import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "BANK-SERVICE2",fallback = AccountAddFallback.class)
@RequestMapping
public interface AccountAddFeignClient {
	
	@PostMapping("/addAmount")
	@Hmily
    int addAmount(@RequestBody Map<String,Object> map);


}
