package tech.green_egypt.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import tech.green_egypt.domain.model.Tip;

public interface TipRepo extends MongoRepository<Tip,ObjectId> {
    
}
