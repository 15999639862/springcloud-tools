package org.distribute.order.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

	public int saveOrder(Map<String,Object> map);
	
}
