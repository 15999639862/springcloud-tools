package org.distribute.order;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.distribute.order.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class BaseTest {
	
	@Autowired
	private OrderService orderService;
	
	@Test
	public void testSave() {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", UUID.randomUUID().toString());
		map.put("productId", "aaaaa");
		map.put("time", new Date());
		orderService.saveOrder(map);
	}
	
}
