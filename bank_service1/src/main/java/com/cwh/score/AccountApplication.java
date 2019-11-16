package com.cwh.score;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableEurekaClient
@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
@EnableDiscoveryClient
@EnableAspectJAutoProxy
@ComponentScan({ "com.cwh.score", "org.dromara.hmily" })
public class AccountApplication extends SpringBootServletInitializer {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return super.configure(builder);
	}

}
