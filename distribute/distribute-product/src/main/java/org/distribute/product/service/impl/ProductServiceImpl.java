package org.distribute.product.service.impl;

import java.util.Map;

import org.distribute.product.mapper.ProductMapper;
import org.distribute.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	private ProductMapper productMapper;
	
	public int saveProduct(Map<String, Object> map) {
		return productMapper.insertProduct(map);
	}
	
	
}
