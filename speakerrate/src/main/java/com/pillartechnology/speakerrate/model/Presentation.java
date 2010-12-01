package com.pillartechnology.speakerrate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Presentation extends EntityBase {

	@NotNull
	@Column(unique=true)
	private String title;
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
