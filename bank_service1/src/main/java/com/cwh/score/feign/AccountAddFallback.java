package com.cwh.score.feign;

import java.util.Map;

public class AccountAddFallback implements AccountAddFeignClient{

	public int addAmount(Map<String, Object> map) {
		return 0;
	}

}
