package com.spring.webservice.restapi.hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloContoller {
@RequestMapping(method = RequestMethod.GET,path="/hello/{names}")
public HelloBean helloWorld(@PathVariable String names) {
		return  new HelloBean("hello world user " + names + " welcome to wonderland.");
	}
}
