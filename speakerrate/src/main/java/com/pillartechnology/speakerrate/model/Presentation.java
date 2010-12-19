package com.pillartechnology.speakerrate.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

@Entity
public class Presentation extends EntityBase {

	@NotBlank
	@Column(unique=true)
	private String title;
	
	@NotNull
	private Date presentedAt;

	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="presentation")
	private Set<Rating> ratings = new HashSet<Rating>();
	
	public double getAverageContentScore() {
		return average(new Function<Rating,Integer>(){
			@Override public Integer apply(Rating rating) {
				return rating.getContentScore();
			}
		});
	}

	public double getAverageDeliveryScore() {
		return average(new Function<Rating,Integer>(){
			@Override public Integer apply(Rating rating) {
				return rating.getDeliveryScore();
			}
		});
	}
	
	private double average(Function<Rating,Integer> transformer) {
		double avg = 0.0;
		int count = 1;
		Iterable<Integer> scores = Iterables.transform(ratings,transformer);
		for (Integer score : scores) {
			avg += (score - avg) / count++;
		}
		return avg;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPresentedAt() {
		return presentedAt;
	}
	public void setPresentedAt(Date presentedAt) {
		this.presentedAt = presentedAt;
	}
	public Set<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}
	
}
