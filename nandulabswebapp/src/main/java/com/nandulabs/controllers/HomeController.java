package com.nandulabs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nandulabs.model.StatusUpdate;
import com.nandulabs.service.StatusUpdateService;

@Controller
public class HomeController {
	
	@Autowired
	private StatusUpdateService statusUpdateService;
	
	@RequestMapping("/")
	public ModelAndView home(ModelAndView model) {
		
		StatusUpdate statusUpdate = this.statusUpdateService.getLatest();
		model.getModel().put("statusUpdate", statusUpdate);
		model.setViewName("app.home");
		return model;
	}

	@RequestMapping("/about")
	public String about() {
		return "app.about";
	}

	
}
