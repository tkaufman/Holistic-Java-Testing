package com.pillartechnology.speakerrate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Presentation extends EntityBase {

	@NotBlank
	@Column(unique=true)
	private String title;
	
	@NotNull
	private Date presentedAt;

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
	
}
