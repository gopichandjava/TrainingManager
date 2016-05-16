package org.sample.controller;

import org.sample.model.UserCredentials;
import org.sample.validate.ValidateCredentials;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userdetails")
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String beforeLogin(Model model)
	{
//		UserDetails userdetails = new UserDetails();
//		userdetails.setPassword("enter pasword");
//		userdetails.setUserId("enter userid");
		model.addAttribute("userdetails", new UserCredentials());
		
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String afterLogin(@ModelAttribute("userdetails") UserCredentials userdetails)
	{
		System.out.println("userid is "+userdetails.getUserId());
		//model.addAttribute("loging", "login page");
		ValidateCredentials validate = new ValidateCredentials();
		 boolean result =  validate.valiatePassword(userdetails.getPassword());
		if(result==false)
		{
			return "login";
		}
		else
		{
			return "redirect:home.html";
		}
	
	}
	@RequestMapping(value="/home")
	public String home(Model model)
	{
		//model.addAttribute("loging", "login page");
		
		return "home";
	}
	
	
	
}
