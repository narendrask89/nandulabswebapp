package com.nandulabs.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nandulabs.model.StatusUpdate;
import com.nandulabs.service.StatusUpdateService;

@Controller
public class StatusUpdateController {

	@Autowired
	private StatusUpdateService statusUpdateService;
	
	@GetMapping(value="/deletestatus")
	public ModelAndView deleteStatus(ModelAndView model, @RequestParam(name="id") Long id) {
		
		statusUpdateService.deleteStatus(id);
		model.setViewName("redirect:/viewstatus");
		return model;
	}
	
	@GetMapping(value="/editstatus")
	public ModelAndView editStatus(ModelAndView model, @RequestParam(name="id") Long id) {
		
		StatusUpdate statusUpdate = statusUpdateService.retrieveStatus(id);
		model.getModel().put("statusUpdate", statusUpdate);
		model.setViewName("app.editstatus");
		return model;
	}
	
	@PostMapping(value = "/editstatus")
	public ModelAndView updateStatus(ModelAndView model, @Valid StatusUpdate statusUpdate, BindingResult result) {
		
		model.setViewName("app.editstatus");
		
		if(!result.hasErrors()) {
			this.statusUpdateService.save(statusUpdate);
			model.setViewName("redirect:/viewstatus");
		}
		
		return model;
	}
	
	@GetMapping(value="/viewstatus")
	public ModelAndView viewStatus(ModelAndView modelAndView, @RequestParam(name="p", defaultValue="1") int pageNumber) {
		
		Page<StatusUpdate> viewStatus = this.statusUpdateService.viewStatus(pageNumber);
		modelAndView.getModel().put("page", viewStatus);
				
		modelAndView.setViewName("app.viewstatus");
		return modelAndView;
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
		
		model.setViewName("app.addstatus");
		
		if(!result.hasErrors()) {
			this.statusUpdateService.save(statusUpdate);
			model.getModel().put("statusUpdate", new StatusUpdate());
			model.setViewName("redirect:/viewstatus");
		}
		
		StatusUpdate latestStatusUpdate = this.statusUpdateService.getLatest();
		model.getModel().put("latestStatusUpdate", latestStatusUpdate);
		
		return model;
	}
}
