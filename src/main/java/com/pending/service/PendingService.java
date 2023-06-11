package com.pending.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pending.entity.Pending;
import com.pending.exception.PendingNotFoundException;
import com.pending.repository.PendingRepository;

@Service
public class PendingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PendingService.class);

	private PendingRepository pendingRepository;

	public PendingService(PendingRepository pendingRepository) {
		this.pendingRepository = pendingRepository;
	}

	public List<Pending> getPendings(String username) {
		List<Pending> pendings = this.pendingRepository.findByReferenceAndUsername(null, username);
		LOGGER.warn("Total de pendientes de " +  username + ": " + pendings.size());
		return pendings;
	}

	public Pending getPending(String id) {
		LOGGER.warn("Pendiente id ... ");
		return this.pendingRepository.findById(id).orElseThrow(() -> new PendingNotFoundException(id));
	}

	public List<Pending> getPendingHistory(String id) {
		LOGGER.warn("Historia del id ... " + id);
		List<Pending> pendingsHistory = this.pendingRepository.findByReference(id);
		LOGGER.info("Este es el historico" + pendingsHistory);
		return pendingsHistory;
	}

	public ResponseEntity<Pending> addPending(Pending pending) {
		LOGGER.warn("Agregando pendiente: " + pending);
		Pending newPending = this.pendingRepository.save(pending);
		return new ResponseEntity<Pending>(newPending, HttpStatus.CREATED);
	}

	public HttpStatus updatePending(Pending updatePending) {
		createHistory(updatePending);
		this.pendingRepository.save(updatePending);

		return HttpStatus.NO_CONTENT;

	}

	private void createHistory(Pending updatePending) {
		LOGGER.warn("Actulizando pendiente " + updatePending);
		Pending pendingHistory = this.pendingRepository.findById(updatePending.getId())
				.orElseThrow(() -> new PendingNotFoundException(updatePending.getId()));
		pendingHistory.setId(null);
		pendingHistory.setReference(updatePending.getId());
		this.pendingRepository.save(pendingHistory);
	}

	public HttpStatus deletePendingById(String id) {
		LOGGER.warn("Eliminando pendiente " + id);
		Optional<Pending> result = this.pendingRepository.findById(id);
		if (result.isPresent()) {
			this.pendingRepository.deleteById(id);
			deleteHistory(id);
			return HttpStatus.NO_CONTENT;
		}
		return HttpStatus.NOT_FOUND;
	}

	private void deleteHistory(String id) {
		this.pendingRepository.deleteByReference(id);

	}

}
