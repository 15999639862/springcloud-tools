package com.cwh.score.feign;

import java.util.Map;

public class UserFallback implements UserFeignClient{

	public int saveUser(Map<String, Object> map) {
		return 0;
	}

}
