package com.cwh.user.config;

import org.dromara.hmily.common.config.HmilyDbConfig;
import org.dromara.hmily.core.bootstrap.HmilyTransactionBootstrap;
import org.dromara.hmily.core.service.HmilyInitService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan("com.cwh.user.mapper")
@EnableConfigurationProperties
@AutoConfigureAfter(value = { HmilyProperty.class,HmilyDBProperty.class})
public class DataBaseConfig {

	@Autowired
	private HmilyProperty hmilyProperty;
	
	@Autowired
	private HmilyDBProperty hmilyDBProperty;
	
	@Bean("duridDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DruidDataSource duridDataSource() {
		return new DruidDataSource();
	}
	
	@Bean
	public HmilyTransactionBootstrap hmilyTransactionBootstrap(HmilyInitService hmilyInitService) {
		HmilyTransactionBootstrap strap = new HmilyTransactionBootstrap(hmilyInitService);
		strap.setSerializer(hmilyProperty.getSerializer());
		strap.setRecoverDelayTime(hmilyProperty.getRecoverDelayTime());
		strap.setRetryMax(hmilyProperty.getRetryMax());
		strap.setScheduledDelay(hmilyProperty.getScheduledDelay());
		strap.setScheduledThreadMax(hmilyProperty.getScheduledThreadMax());
		strap.setRepositorySupport(hmilyProperty.getRepositorySupport());
		strap.setStarted(hmilyProperty.isStarted());
		
		HmilyDbConfig hmilyDbConfig = new HmilyDbConfig();
		hmilyDbConfig.setUrl(hmilyDBProperty.getUrl());
		hmilyDbConfig.setDriverClassName(hmilyDBProperty.getDriverClassName());
		hmilyDbConfig.setUsername(hmilyDBProperty.getUsername());
		hmilyDbConfig.setPassword(hmilyDBProperty.getPassword());
		
		strap.setHmilyDbConfig(hmilyDbConfig);
		return strap;
	}  
	
	
	
}
