/**
 * 
 */
package com.loadbalancer.demo.config.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Ashish
 *
 */
@Component
@ConfigurationProperties(prefix="instance")
@PropertySource({"classpath:/config/server-instance.properties"})
public class AvailableServerConfiguration {

	private List<String> serverList = new ArrayList<String>();

	public List<String> getServerList() {
		return serverList;
	}

	public void setServerList(List<String> serverList) {
		this.serverList = serverList;
	}
}
