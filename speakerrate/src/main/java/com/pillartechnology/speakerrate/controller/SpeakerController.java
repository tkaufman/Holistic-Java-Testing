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

import com.pillartechnology.speakerrate.model.Speaker;
import com.pillartechnology.speakerrate.persistence.SpeakerRepository;

@Controller
@Transactional
@RequestMapping("speakers")
public class SpeakerController {
	
	private SpeakerRepository speakerRepo;
	
	@RequestMapping
	public String index(Model model) {
		model.addAttribute("speakers", speakerRepo.findAll());
		return "speakers/index";
	}
	
	@RequestMapping(value="{id}")
	public String show(@PathVariable long id, Model model) {
		model.addAttribute("speaker", speakerRepo.findById(id));
		return "speakers/show";
	}

	@RequestMapping(value="new")
	public String newForm(Model model) {
		model.addAttribute(new Speaker());
		return "speakers/new";
	}
	
	@RequestMapping(value="create", method = RequestMethod.POST)
	public String create(@Valid Speaker speaker, BindingResult result) {
		speakerRepo.persist(speaker);
		return "speakers/show";
	}

	@Autowired
	public void setSpeakerRepo(SpeakerRepository speakerRepo) {
		this.speakerRepo = speakerRepo;
	}
}

