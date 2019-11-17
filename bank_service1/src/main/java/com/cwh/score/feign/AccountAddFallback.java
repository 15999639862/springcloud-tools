package com.cwh.score.feign;

public class AccountAddFallback implements AccountAddFeignClient{

	public long addAmount(double amount) {
		return 0;
	}

}
