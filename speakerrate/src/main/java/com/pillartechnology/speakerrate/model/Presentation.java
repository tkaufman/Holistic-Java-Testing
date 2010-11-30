package com.pillartechnology.speakerrate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Presentation extends EntityBase {

	private String title;
	private Date presentedAt;

	@NotNull
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
