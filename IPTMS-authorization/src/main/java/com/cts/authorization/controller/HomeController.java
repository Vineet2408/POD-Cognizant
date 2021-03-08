package com.cts.authorization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController 
{
	@GetMapping("/")
	public String home()
	{
		return ("<h1>Welcome home</h1>");
	}
	@GetMapping("/home")
	public String gethome()
	{
		return ("<h1>Welcome home</h1>");
	}
	@GetMapping("/user")
	public String userHome()
	{
		return ("<h1>Welcome user</h1>");
	}

	@GetMapping("/admin")
	public String userAdmin()
	{
		return ("<h1>Welcome usadminer</h1>");
	}
}
