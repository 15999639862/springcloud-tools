package com.cwh.score.service;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cwh.score.mapper.ScoreMapper;

@Service
public class ScoreService {

	@Autowired
	private ScoreMapper scoreMapper;
	
	@Transactional
	public int saveUserScore(Map<String,Object> map) {
		return scoreMapper.saveUserScore(map);
	}
	
	
}
