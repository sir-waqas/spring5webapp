package com.mabsapps.spring5webapp.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Salam ,%s !!!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greet")
	public Greeting greet(@RequestParam(value = "name", defaultValue = "Brother") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
