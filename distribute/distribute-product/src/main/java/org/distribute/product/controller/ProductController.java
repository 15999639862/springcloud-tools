package org.distribute.product.controller;
 
import java.util.Map;

import org.distribute.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/updateProduct")
	public int saveProduct(@RequestBody Map<String,Object> map) {
		return productService.saveProduct(map);
	}
	
}
