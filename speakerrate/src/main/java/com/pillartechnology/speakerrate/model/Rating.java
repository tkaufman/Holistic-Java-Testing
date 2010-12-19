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
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Rating extends EntityBase {

	public enum Status {SOLICITED, COMPLETE};
	
	@ManyToOne
	private Presentation presentation;
	
	@NotBlank
	@Email
	private String email;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status = Status.SOLICITED;
	
	@Min(0)
	@Max(100)
	private int contentScore;
	
	@Min(0)
	@Max(100)
	private int deliveryScore;
	
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

	public int getContentScore() {
		return contentScore;
	}

	public void setContentScore(int contentScore) {
		this.contentScore = contentScore;
	}

	public int getDeliveryScore() {
		return deliveryScore;
	}

	public void setDeliveryScore(int deliveryScore) {
		this.deliveryScore = deliveryScore;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
