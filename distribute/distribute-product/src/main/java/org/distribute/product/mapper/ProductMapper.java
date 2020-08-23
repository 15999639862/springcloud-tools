package org.distribute.product.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
	
	public int insertProduct(Map<String,Object> map);

}
