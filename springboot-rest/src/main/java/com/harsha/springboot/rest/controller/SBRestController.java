package com.harsha.springboot.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SBRestController {

	@GetMapping("/GetStatus")
	public String getStatus() {

		return "Hello world!";

	}
}
