package org.distribute.order.controller;

import java.util.Map;

import org.distribute.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/saveOrder")
	public int saveOrder(@RequestBody Map<String,Object> map) {
		return orderService.saveOrder(map);
	}
	
	
	
}
