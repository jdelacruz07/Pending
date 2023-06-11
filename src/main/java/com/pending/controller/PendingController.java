package com.pending.controller;

import java.net.URISyntaxException;
import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pending.entity.Pending;
import com.pending.service.PendingService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/pending")
public class PendingController {

//	private static final Logger LOGGER = LoggerFactory.getLogger(Pending.class);

	private PendingService pendingService;

	public PendingController(PendingService pendingService) {
		super();
		this.pendingService = pendingService;
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping()
	public ResponseEntity<List<Pending>> getPendings(Principal user) {
		List<Pending> pendings = this.pendingService.getPendings(user.getName());
		return ResponseEntity.ok(pendings);
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/{id}")
	public ResponseEntity<Pending> getPending(@PathVariable String id) {
		Pending pending = this.pendingService.getPending(id);
		return ResponseEntity.ok(pending);
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/history/{id}")
	public ResponseEntity<List<Pending>> getPendingHistory(@PathVariable String id) {
		List<Pending> pendingsHistory = this.pendingService.getPendingHistory(id);
		return ResponseEntity.ok(pendingsHistory);
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping()
	public ResponseEntity<Pending> addPending(@RequestBody Pending pending) throws URISyntaxException {
		return this.pendingService.addPending(pending);
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@PutMapping()
	public HttpStatus updatePending(@RequestBody Pending pending) {
		return this.pendingService.updatePending(pending);
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@DeleteMapping("/{id}")
	public HttpStatus deletePending(@PathVariable String id) {
		return this.pendingService.deletePendingById(id);

	}

}