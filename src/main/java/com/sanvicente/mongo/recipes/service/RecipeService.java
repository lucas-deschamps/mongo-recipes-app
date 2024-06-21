package com.sanvicente.mongo.recipes.service;

import com.sanvicente.mongo.recipes.model.Recipe;
import com.sanvicente.mongo.recipes.repository.RecipeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> getRecipeById(String id) {
        return recipeRepository.findById(id);
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(String id, Recipe recipeDetails) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            recipe.setTitle(recipeDetails.getTitle());
            recipe.setAuthor(recipeDetails.getAuthor());
            recipe.setIngredients(recipeDetails.getIngredients());
            recipe.setSteps(recipeDetails.getSteps());
            recipe.setCreatedAt(recipeDetails.getCreatedAt());
            recipe.setTags(recipeDetails.getTags());
            return recipeRepository.save(recipe);
        }
        return null;
    }

    public void deleteRecipe(String id) {
        recipeRepository.deleteById(id);
    }
}
