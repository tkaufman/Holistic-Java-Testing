package com.pillartechnology.speakerrate.persistence;

import org.springframework.stereotype.Repository;

import com.pillartechnology.speakerrate.model.Speaker;

@Repository
public class SpeakerRepository extends JpaRepository<Speaker> {

}
