/**
 * 
 */
package com.loadbalancer.instance.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Ashish
 *
 */
@Component
@ConfigurationProperties(prefix = "server")
public class ServerPort {

	private String port;

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
}
