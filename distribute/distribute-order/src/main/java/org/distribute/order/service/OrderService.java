package org.distribute.order.service;

import java.util.Map;

import javax.annotation.Resource;

import org.distribute.order.mapper.OrderMapper;
import org.distribute.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService{
	

	@Autowired
	private OrderMapper orderMapper;
	
	public int saveOrder(Map<String, Object> map) {
		return orderMapper.saveOrder(map);
	}
	

}
