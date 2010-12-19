package com.pillartechnology.speakerrate.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pillartechnology.speakerrate.model.Presentation;
import com.pillartechnology.speakerrate.persistence.PresentationRepository;

@Controller
@Transactional
@RequestMapping("presentations")
public class PresentationController {

	private PresentationRepository presentationRepository;

	@RequestMapping
	public String index(Model model) {
		model.addAttribute("presentations", presentationRepository.findAll());
		return "presentations/index";
	}
	
	@RequestMapping(value="{id}")
	public String show(@PathVariable long id, Model model) {
		model.addAttribute("presentation", presentationRepository.findById(id));
		return "presentations/show";
	}
	
	@RequestMapping(value="new")
	public String newForm(Model model) {
		model.addAttribute(new Presentation());
		return "presentations/new";
	}

	@RequestMapping(value="create", method = RequestMethod.POST)
	public String create(@Valid Presentation presentation, BindingResult result) {
		if(result.hasErrors()) { return "presentations/new"; }
		presentationRepository.persist(presentation);
		return "redirect:"+presentation.getId();
	}

	@Autowired
	public void setPresentationRepository(PresentationRepository presentationRepository) {
		this.presentationRepository = presentationRepository;
	}

}
