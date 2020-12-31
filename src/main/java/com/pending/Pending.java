package com.pending;

import org.springframework.data.annotation.Id;

public class Pending {
	
	@Id
	private String id;
	private String pending;
	
	public Pending() {
		super();
	}

	public Pending(String pending) {
		super();
		this.pending = pending;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPending() {
		return pending;
	}

	public void setPending(String pending) {
		this.pending = pending;
	}
	
	
	
	

}
