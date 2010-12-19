package com.pillartechnology.speakerrate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pillartechnology.speakerrate.persistence.RatingRepository;

@Controller
@RequestMapping("/ratings")
public class RatingController {

	private RatingRepository ratingRepository;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String show(@PathVariable long id, Model model) {
		model.addAttribute("rating", ratingRepository.findById(id));
		return "ratings/show";
	}
	
	@Autowired
	public void setRatingRepository(RatingRepository ratingRepository) {
		this.ratingRepository = ratingRepository;
	}
	
}
