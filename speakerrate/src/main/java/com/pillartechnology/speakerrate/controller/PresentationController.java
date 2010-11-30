package com.pillartechnology.speakerrate.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pillartechnology.speakerrate.model.Presentation;
import com.pillartechnology.speakerrate.persistence.PresentationRepository;

@Controller
@RequestMapping("/presentations")
public class PresentationController {

	private PresentationRepository presentationRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("presentations", presentationRepository.findAll());
		return "presentations/index";
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public String show(@PathVariable long id, Model model) {
		model.addAttribute("presentation", presentationRepository.findById(id));
		return "presentations/show";
	}
	
	@RequestMapping(value="/new",method = RequestMethod.GET)
	public String newForm(Model model) {
		model.addAttribute(new Presentation());
		return "presentations/new";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Presentation presentation, BindingResult result) {
		presentationRepository.persist(presentation);
		return "redirect:presentations/"+presentation.getId();
	}

	@Autowired
	public void setPresentationRepository(PresentationRepository presentationRepository) {
		this.presentationRepository = presentationRepository;
	}

}
