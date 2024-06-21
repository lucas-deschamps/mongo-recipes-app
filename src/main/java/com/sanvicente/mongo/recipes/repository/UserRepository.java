package com.sanvicente.mongo.recipes.repository;

import com.sanvicente.mongo.recipes.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
