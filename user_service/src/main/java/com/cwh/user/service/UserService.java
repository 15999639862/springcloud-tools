package com.cwh.user.service;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cwh.user.feign.ScoreFeignClient;
import com.cwh.user.mapper.UserMapper;

import io.seata.spring.annotation.GlobalTransactional;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ScoreFeignClient scoreFeignClient;
	
	@GlobalTransactional
	@Transactional
	public int saveUser(Map<String,Object> map) {
		scoreFeignClient.saveUserScore(map);
		return userMapper.saveUser(map);
	}

}
