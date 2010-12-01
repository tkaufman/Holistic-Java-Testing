package com.pillartechnology.speakerrate.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Rating extends EntityBase {

	public enum Status {SOLICITED, COMPLETE};
	
	@ManyToOne
	private Presentation presentation;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status = Status.SOLICITED;
	
	@Min(0)
	@Max(100)
	private long contentScore;
	
	@Min(0)
	@Max(100)
	private long deliveryScore;
	
	@Size(max=255)
	private String comment;

	public Presentation getPresentation() {
		return presentation;
	}

	public void setPresentation(Presentation presentation) {
		this.presentation = presentation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public long getContentScore() {
		return contentScore;
	}

	public void setContentScore(long contentScore) {
		this.contentScore = contentScore;
	}

	public long getDeliveryScore() {
		return deliveryScore;
	}

	public void setDeliveryScore(long deliveryScore) {
		this.deliveryScore = deliveryScore;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
