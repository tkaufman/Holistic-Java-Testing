package com.pillartechnology.speakerrate.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pillartechnology.speakerrate.model.Speaker;

@Repository
@Transactional
public class JpaSpeakerRepository extends JpaRepository<Speaker> implements SpeakerRepository {

}
