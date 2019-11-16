package com.cwh.score.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cwh.score.service.ScoreService;

@RestController
public class ScoreController {

	@Autowired
	private ScoreService scoreService;
	
	@PostMapping("saveUserScore")
	@ResponseBody
	public int saveUserScore(@RequestBody Map<String,Object> map) {
		return scoreService.saveUserScore(map);
	}
	
}
