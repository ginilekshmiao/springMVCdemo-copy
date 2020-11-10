package com.demo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.demo.model.Account;

@Controller
@SessionAttributes("aNewAttribute")
public class MyDemoController2 {
	
	@ModelAttribute
	public void addAccountToModel(Model model) {
		
		System.out.println("Making sure account object is on model");
		if(!model.containsAttribute("aNewAccount")) {
			Account a = new Account();
			model.addAttribute("aNewAccount",a);
		}
	}
	@RequestMapping(value="/createAccount", method=RequestMethod.POST)
	public String createAccount(@Valid @ModelAttribute ("aNewAccount")Account account, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("form has errors");
			return "createAccount";
		}
		System.out.println(account.getFirstName() + " " + account.getLastName());
		return "createAccount";
	}
	@RequestMapping(value="/doCreate")
	public String doCreate(@ModelAttribute ("aNewAccount")Account account ) {
		
		System.out.println("Do create: new account info : " +account.getFirstName() + " " + account.getLastName());
		System.out.println("Do create: going off and creating an actual account " );
		return "redirect:accConfirm.html";
		
	}
	@RequestMapping(value="/accConfirm")
	public String accountConfirmation(@ModelAttribute ("aNewAccount")Account account ) {
		
		System.out.println("Account confirmed : " +account.getFirstName() + " " + account.getLastName());
		
		return "accountConfirmed";
	}
}
