package com.cwh.user.feign;

import java.util.Map;

public class AccountFallback implements AccountFeignClient{

	public int addAmount(Map<String, Object> map) {
		return 0;
	}

}
