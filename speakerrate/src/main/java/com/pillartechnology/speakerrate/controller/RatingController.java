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

import com.pillartechnology.speakerrate.model.Rating;
import com.pillartechnology.speakerrate.persistence.PresentationRepository;
import com.pillartechnology.speakerrate.persistence.RatingRepository;

@Controller
@Transactional
@RequestMapping("presentations/{presentationId}/ratings")
public class RatingController {

	private PresentationRepository presentationRepository;
	private RatingRepository ratingRepository;
	
	@RequestMapping("{id}")
	public String show(@PathVariable long id, Model model) {
		model.addAttribute("rating", ratingRepository.findById(id));
		return "ratings/show";
	}
	
	@RequestMapping(value="new")
	public String newForm(@PathVariable long presentationId, Model model) {
		model.addAttribute(new Rating());
		return "ratings/new";
	}

	@RequestMapping(value="create", method=RequestMethod.POST)
	public String create(@PathVariable long presentationId, @Valid Rating rating, BindingResult result) {
		if(result.hasErrors()) { return "ratings/new"; }
		rating.setPresentation(presentationRepository.findById(presentationId));
		ratingRepository.persist(rating);
		return "redirect:../../"+presentationId;
	}

	@Autowired
	public void setRatingRepository(RatingRepository ratingRepository) {
		this.ratingRepository = ratingRepository;
	}

	@Autowired
	public void setPresentationRepository(PresentationRepository presentationRepository) {
		this.presentationRepository = presentationRepository;
	}

}
