package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainServlet {

	
	@RequestMapping(value = "/main" , method =  RequestMethod.GET)
	public String main() {
		System.out.println("main start");
		return "main/index";
	}

}

