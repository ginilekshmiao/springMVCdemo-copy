package com.demo.controllers;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyDemoController {
	//http://localhost:8080/springMVCDemo/getQuote.html
	
	private String[] quotes= {"to be or not to be","all is well","failure is the key to success"
								
	};
	//@RequestMapping(value="/getQuote",params="from=keisha")
	//@RequestMapping(value="/getQuote",headers="X-API-KEY=12345")
	@RequestMapping(value="/getQuote")
	public String getRandomQuote(Model model) {
	//public String getRandomQuote(@RequestParam("userName") String userName, Model model) {
		
		int rand = new Random().nextInt(quotes.length);
		String randomQuote=quotes[rand];
		//System.out.println("username is " + userName);
		//model.addAttribute("randomQuote",randomQuote);
		model.addAttribute("randomQuote",randomQuote);
		System.out.println("model updated with random quote");
		return "quote";
	}
	@ModelAttribute
	public void setUserDetails(@RequestParam("userName") String userName, Model model) {
		model.addAttribute("userName",userName);
		
		String userRole = "undefined";
		if(userName.equals("Andy")) {
			userRole="student";
		}
		else if(userName.equals("John")) {
			userRole="teacher";
		}
		else if(userName.equals("Allana")) {
			userRole="dean";

		}
		model.addAttribute("userRole",userRole);
		System.out.println("model updated with user information");
	}
}
