package com.loadbalancer.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.loadbalancer.demo.config.server.AvailableServerConfiguration;

/**
 * @author Ashish
 *
 */
@SpringBootApplication
public class LoadBalancerApplication {

	@Autowired
	AvailableServerConfiguration serverConfig;
	
	public static void main(String[] args) {
		SpringApplication.run(LoadBalancerApplication.class, args);
	}
	
	@PostConstruct
	private void display() {
		System.out.println(serverConfig.getServerList());
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
