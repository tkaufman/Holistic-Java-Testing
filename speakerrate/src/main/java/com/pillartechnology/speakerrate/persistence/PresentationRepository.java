package com.pillartechnology.speakerrate.persistence;

import java.util.List;

import com.pillartechnology.speakerrate.model.Presentation;

public interface PresentationRepository extends Repository<Presentation> {

	public List<Presentation> findRecommendedPresentations(int rating);

}
