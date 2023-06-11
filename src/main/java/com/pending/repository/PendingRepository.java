package com.pending.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pending.entity.Pending;

public interface PendingRepository extends MongoRepository<Pending, String> {

	List<Pending> findByTopic(String topic);

	List<Pending> findByReference(String reference);

	List<Pending> findByReferenceAndUsername(String reference, String username);

	void deleteByReference(String id);

}
