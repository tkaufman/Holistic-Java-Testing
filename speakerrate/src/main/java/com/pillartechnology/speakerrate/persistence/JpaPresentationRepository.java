package com.pillartechnology.speakerrate.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pillartechnology.speakerrate.model.Presentation;

@Repository
@Transactional
public class JpaPresentationRepository extends JpaRepository<Presentation> implements PresentationRepository {

}
