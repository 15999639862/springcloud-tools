package com.cwh.user.config;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

import io.seata.rm.datasource.DataSourceProxy;


@Configuration
@MapperScan("com.cwh.user.mapper")
@EnableConfigurationProperties
public class DataBaseConfig {
	
	@Bean("duridDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DruidDataSource duridDataSource() {
		return new DruidDataSource();
	}
	
	/**
	 * 配置数据源代理，用于事务回滚
	 *
	 * @return The default datasource
	 * @see DataSourceProxy
	 */
	@Primary
	@Bean("dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource(DruidDataSource duridDataSource) {
	    return new DataSourceProxy(duridDataSource);
	}
	
}
