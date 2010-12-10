package com.pillartechnology.speakerrate.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pillartechnology.speakerrate.model.Rating;

@Repository
@Transactional
public class JpaRatingRepository extends JpaRepository<Rating> implements RatingRepository {

}
