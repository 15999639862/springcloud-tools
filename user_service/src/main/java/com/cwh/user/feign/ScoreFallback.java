package com.cwh.user.feign;

import java.util.Map;

public class ScoreFallback implements ScoreFeignClient{

	public int saveUserScore(Map<String, Object> map) {
		return 0;
	}

}
