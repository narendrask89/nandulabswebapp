package com.nandulabs.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nandulabs.model.StatusUpdate;
import com.nandulabs.service.StatusUpdateService;

@Controller
public class HomeController {

	@Autowired
	private StatusUpdateService statusUpdateService;
	
	@RequestMapping("/")
	public String home() {
		return "app.home";
	}

	@RequestMapping("/about")
	public String about() {
		return "app.about";
	}

	@GetMapping(value = "/addstatus")
	public ModelAndView addStatus(ModelAndView model, @ModelAttribute("statusUpdate")StatusUpdate statusUpdate) {

		StatusUpdate latestStatusUpdate = this.statusUpdateService.getLatest();
		model.getModel().put("latestStatusUpdate", latestStatusUpdate);
		
		model.setViewName("app.addstatus");
		return model;
	}

	@PostMapping(value = "/addstatus")
	public ModelAndView addStatus(ModelAndView model, @Valid StatusUpdate statusUpdate, BindingResult result) {
		
		if(!result.hasErrors()) {
			this.statusUpdateService.save(statusUpdate);
			model.getModel().put("statusUpdate", new StatusUpdate());
		}
		
		StatusUpdate latestStatusUpdate = this.statusUpdateService.getLatest();
		model.getModel().put("latestStatusUpdate", latestStatusUpdate);
		
		model.setViewName("app.addstatus");
		return model;
	}
}
