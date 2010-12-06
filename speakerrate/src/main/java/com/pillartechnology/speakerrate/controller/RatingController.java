package com.pillartechnology.speakerrate.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.pillartechnology.speakerrate.persistence.*;

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
