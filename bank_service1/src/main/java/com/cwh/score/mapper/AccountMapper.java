package com.cwh.score.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {

	public int addAmount(Map<String,Object> map);
	
	public int decAmount(Map<String,Object> map);
	
	public int addTryLog(@Param("tid")String tid);
	
	public int addConfirmLog(@Param("tid")String tid);
	
	public int addCancelLog(@Param("tid")String tid);
	
	public int existTryLog(@Param("tid")String tid);
	
	public int existConfirmLog(@Param("tid")String tid);
	
	public int existCancelLog(@Param("tid")String tid);
	
}
