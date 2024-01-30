package com.newproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Anno {

	@GetMapping("baby / name")
	public String getName() {
		return "mann";
	}
	
}
