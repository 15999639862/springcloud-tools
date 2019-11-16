package com.cwh.user.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "SCORE-SERVICE",fallback = ScoreFallback.class)
@RequestMapping(value = "/score-service")
public interface ScoreFeignClient {
	
	@PostMapping("/saveUserScore")
    int saveUserScore(@RequestBody Map<String,Object> map);


}
