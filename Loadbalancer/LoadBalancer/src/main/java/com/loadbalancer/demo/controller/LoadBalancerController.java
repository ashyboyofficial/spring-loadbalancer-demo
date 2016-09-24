package com.loadbalancer.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.loadbalancer.demo.config.server.AvailableServerConfiguration;

/**
 * @author Ashish
 *
 */
@RestController
public class LoadBalancerController {

	private static int NEXT_SERVER = 0;
	private static String STATUS = "Fail";

	@Autowired
	private AvailableServerConfiguration availableServerConfiguration;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/fetch", method = RequestMethod.GET)
	public Object getString() {
		String fetchedData = null;
		int attempt = 0;
		do {
			try {
				fetchedData = this.restTemplate.getForObject("http://" + getRandomServer() + "/data", String.class);
				STATUS = "Success";
			} catch (RestClientException e) {
				System.out.println(e.getMessage());
				System.out.println("Connect Attempt Failed: " + ++attempt);
				STATUS = "Fail";
			}
		} while (STATUS.equals("Fail") && attempt < 4);
		if(fetchedData == null)
			return new ModelAndView("redirect:error");
		return String.format("Data received from %s", fetchedData);
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorPage() {
		return String.format("Error Page");
	}

	private String getRandomServer() {
		List<String> servers = availableServerConfiguration.getServerList();
		if (NEXT_SERVER >= servers.size())
			NEXT_SERVER = 0;
		int next = NEXT_SERVER++;
		return servers.get(next);
	}
}
