package com.niit.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController 
{
	//Routing Technique
	@RequestMapping(value = {"/","/home"})
	public String m1()
	{
		return "index";
	}
	
	@RequestMapping(value ={"/login","/loginpage"})
	public String m2()
	{
		return "login";
	}
}
