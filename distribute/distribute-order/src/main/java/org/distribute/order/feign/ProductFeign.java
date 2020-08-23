package org.distribute.order.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "PRODUCT-SERVICE")
@RequestMapping("/product")
public interface ProductFeign {

	@PostMapping("/updateProduct")
    public void updateProduct(@RequestBody Map<String,Object> map);
	
}
