package org.distribute.order.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.distribute.order.feign.ProductFeign;
import org.distribute.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.seata.spring.annotation.GlobalTransactional;

@Service
public class OrderService{
	

	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private ProductFeign productFeign;
	
	@GlobalTransactional(name = "order-service",rollbackFor = Exception.class)
	public int saveOrder(Map<String, Object> map) {
		int t = orderMapper.saveOrder(map);
		Map<String,Object> productMap = new HashMap<String, Object>();
		productMap.put("id", UUID.randomUUID().toString());
		productMap.put("name","cwh");
		productMap.put("total",10);
		productFeign.updateProduct(productMap);
		return 1;
	}
	

}
