package com.pending;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface PendInterface extends MongoRepository<Pending, Short>  {

}
