package com.cwh.user.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

	public int saveUser(Map<String,Object> map);
	
}
