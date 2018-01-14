package com.nandulabs.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nandulabs.model.SiteUser;
import com.nandulabs.service.UserService;

@Controller
public class AuthController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String loginPage() {
		return "app.login";
	}

	@GetMapping("/register")
	public ModelAndView register(ModelAndView model) {
		model.getModel().put("user", new SiteUser());
		model.setViewName("app.register");

		return model;
	}

	@PostMapping("/register")
	public ModelAndView register(ModelAndView model, @Valid SiteUser user, BindingResult result) {

		model.setViewName("app.register");
		if (!result.hasErrors()) {
			this.userService.register(user);
			model.setViewName("app.login");
		}
		model.getModel().put("user", new SiteUser());

		return model;
	}
}
