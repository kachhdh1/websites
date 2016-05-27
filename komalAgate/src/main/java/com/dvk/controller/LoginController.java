package com.dvk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

	@RequestMapping(value="/login")
	public String login(@RequestParam(value="error",required=false) String error,
			@RequestParam(value="logout",required=false) String logout,Model model){
		
		if(error!=null){
			model.addAttribute("error", "Invalid Username and Passowrd");
		}
		if(logout!=null){
			model.addAttribute("msg", "You have been succesfully logged out of the application");
		}
		return "login";
	}
}
