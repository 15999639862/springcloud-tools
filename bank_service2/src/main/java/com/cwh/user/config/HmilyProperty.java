package com.cwh.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@EnableConfigurationProperties
@ConfigurationProperties(prefix = "org.dromara.hmily")
@Data
@Configuration
public class HmilyProperty {
	
	private String serializer;
    private int recoverDelayTime;
    private int retryMax;
    private int scheduledDelay;
    private int scheduledThreadMax;
    private String repositorySupport;
    private boolean started;
    
}
