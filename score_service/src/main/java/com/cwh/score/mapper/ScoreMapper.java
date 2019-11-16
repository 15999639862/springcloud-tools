package com.cwh.score.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface ScoreMapper {

	public int saveUserScore(Map<String,Object> map);
	
}
