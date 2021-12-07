package com.qa.dinos.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // tells Spring this is a controller
				// REST compliant
public class DinoController {

	@GetMapping("/helloWorld") // endpoint
	public String hello() {
		return "Hello, World!";
	}
}
