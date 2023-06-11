package com.pending.exception;

public class PendingNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PendingNotFoundException(String id) {
		super("Could not find pending id: " + id);
	}

}
