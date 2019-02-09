package com.loginapp;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

	@RequestMapping(value="/")
	public String doSomethinga() {
		System.out.println("Invoked the controller");
		return "login";
	}
		
		
		
		@RequestMapping(value="/login", method =RequestMethod.GET)
		public String doSomething() {
			System.out.println("Invoked the controller");
			return "admin";
	}
	
}
