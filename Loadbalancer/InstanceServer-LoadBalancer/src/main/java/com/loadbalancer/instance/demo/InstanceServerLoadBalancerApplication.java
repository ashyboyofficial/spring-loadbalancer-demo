package com.loadbalancer.instance.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InstanceServerLoadBalancerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstanceServerLoadBalancerApplication.class, args);
	}
}
