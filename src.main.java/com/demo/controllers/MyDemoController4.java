package com.demo.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyDemoController4 {
	@RequestMapping(value="/addCookie")
	public String addCookie(HttpServletResponse response) {
		
		response.addCookie(new Cookie("myRandomCookie","aCookieIsAdded"));
		System.out.println("Cookie added");
		return "demoPage";
	}
	@RequestMapping(value="/getCookie")
	public String getCookie(@CookieValue("myRandomCookie")String myCookie) {
		System.out.println("cookie retrieved : " + myCookie);
		return "demopage";
	}
}
