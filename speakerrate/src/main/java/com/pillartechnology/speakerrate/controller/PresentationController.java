package com.pillartechnology.speakerrate.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.pillartechnology.speakerrate.persistence.*;

public class PresentationController {

	private PresentationRepository presentationRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("presentations", presentationRepository.findAll());
		return "presentation/list";
	}

	@Autowired
	public void setPresentationRepository(PresentationRepository presentationRepository) {
		this.presentationRepository = presentationRepository;
	}

}
