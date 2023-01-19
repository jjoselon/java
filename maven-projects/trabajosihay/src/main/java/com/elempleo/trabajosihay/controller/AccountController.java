package com.elempleo.trabajosihay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@GetMapping("/new")
	public String formCreateNewAccount() {
		return "account/formcreatenew";
	}
	
	@PostMapping("/save")
	public String saveAccount(@RequestParam(name = "alias") String alias, Model model) {
		model.addAttribute("alias", alias);
		return "account/listaccounts";
	}
}
