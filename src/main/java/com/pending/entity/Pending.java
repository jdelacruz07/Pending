package com.pending.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Pending {

	@Id
	private String id;
	private String username;
	private String topic;
	private Date dateSelected;
	private String reference;

	public Pending() {

	}

	public Pending(String username, String topic, Date dateSelected, String reference) {
		super();
		this.username = username;
		this.topic = topic;
		this.dateSelected = dateSelected;
		this.reference = reference;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Date getDateSelected() {
		return dateSelected;
	}

	public void setDateSelected(Date dateSelected) {
		this.dateSelected = dateSelected;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public String toString() {
		return "Pending [id=" + id + ", username=" + username + ", topic=" + topic + ", dateSelected=" + dateSelected
				+ ", reference=" + reference + "]";
	}

}
