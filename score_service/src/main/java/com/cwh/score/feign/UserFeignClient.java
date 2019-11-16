package com.cwh.score.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "USER-SERVICE",fallback = UserFallback.class)
@RequestMapping(value = "/user-service")
public interface UserFeignClient {
	
	@PostMapping
    int saveUser(@RequestBody Map<String,Object> map);


}
