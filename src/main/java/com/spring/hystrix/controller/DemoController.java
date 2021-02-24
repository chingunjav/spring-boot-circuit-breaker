package com.spring.hystrix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/rest")
public class DemoController {
	
	@HystrixCommand(fallbackMethod = "messagefallback")
	@GetMapping("/getMessage")
	public String getDemo() throws Exception {
		
		throw new Exception("This is an exception");
		
	}
	
	public String messagefallback() {
		
		return "Fallback message";
		
	}
	
	@GetMapping("/messageNormal")
	public String getMessageWithOutFallback() throws Exception {
		
		throw new Exception("Without Fallback!!!");
		
	}
	
	@HystrixCommand(fallbackMethod = "anotherMethod")
	@GetMapping("/anotherMethodExample")
	public String anotherExample() throws Exception{
		
		throw new Exception("This is another example!!!");
		
	}
	
	public String anotherMethod() {
		
		return "Another Method example!!!";
		
	}
}
