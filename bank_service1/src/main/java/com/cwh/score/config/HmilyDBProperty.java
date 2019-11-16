package com.cwh.score.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@EnableConfigurationProperties
@ConfigurationProperties(prefix = "org.dromara.hmily.hmily-db-config")
@Data
@Configuration
public class HmilyDBProperty {
	
	private String url;
	private String driverClassName;
	private String username;
	private String password;
    
}
