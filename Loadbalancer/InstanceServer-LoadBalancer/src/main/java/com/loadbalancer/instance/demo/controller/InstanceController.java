/**
 * 
 */
package com.loadbalancer.instance.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loadbalancer.instance.demo.config.ServerPort;

/**
 * @author Ashish
 *
 */
@RestController
public class InstanceController {

	@Autowired
	private ServerPort serverPort; 
	
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public String getData() {
		return serverPort.getPort();
	}
}
