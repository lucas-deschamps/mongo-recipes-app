package com.sanvicente.mongo.recipes.repository;

import com.sanvicente.mongo.recipes.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
}
