package com.pillartechnology.speakerrate.persistence;

import org.springframework.transaction.annotation.Transactional;

import com.pillartechnology.speakerrate.model.Presentation;

@Transactional
public interface PresentationRepository extends Repository<Presentation> {

}