package com.nandulabs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/addstatus", method = RequestMethod.GET)
	public ModelAndView addStatus(ModelAndView model) {
		StatusUpdate statusUpdate = new StatusUpdate();
		
		StatusUpdate latestStatusUpdate = this.statusUpdateService.getLatest();
		model.getModel().put("latestStatusUpdate", latestStatusUpdate);
		
		model.getModel().put("statusUpdate", statusUpdate);
		model.setViewName("app.addstatus");
		return model;
	}

	@RequestMapping(value = "/addstatus", method = RequestMethod.POST)
	public ModelAndView addStatus(ModelAndView model, StatusUpdate statusUpdate) {
		
		this.statusUpdateService.save(statusUpdate);
		
		StatusUpdate latestStatusUpdate = this.statusUpdateService.getLatest();
		model.getModel().put("latestStatusUpdate", latestStatusUpdate);
		
		model.setViewName("app.addstatus");
		return model;
	}
}
