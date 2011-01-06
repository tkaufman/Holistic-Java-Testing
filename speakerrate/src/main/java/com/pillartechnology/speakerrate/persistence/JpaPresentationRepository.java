package com.pillartechnology.speakerrate.persistence;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pillartechnology.speakerrate.model.Presentation;

@Repository
@Transactional
public class JpaPresentationRepository extends JpaRepository<Presentation> implements PresentationRepository {

	@Override
	public List<Presentation> findRecommendedPresentations(int rating) {
		TypedQuery<Presentation> q = 
			getEntityManager().createQuery(
				"SELECT presentation FROM Rating AS rating JOIN rating.presentation as presentation WHERE rating.contentScore > :rating AND rating.deliveryScore > :rating", 
				Presentation.class
			);
		q.setParameter("rating", rating);
		return q.getResultList();
	}

}
