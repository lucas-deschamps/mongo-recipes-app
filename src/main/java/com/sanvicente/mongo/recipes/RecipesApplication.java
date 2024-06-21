package com.sanvicente.mongo.recipes;

import com.sanvicente.mongo.recipes.model.Ingredient;
import com.sanvicente.mongo.recipes.model.Recipe;
import com.sanvicente.mongo.recipes.model.Step;
import com.sanvicente.mongo.recipes.model.User;
import com.sanvicente.mongo.recipes.repository.RecipeRepository;
import com.sanvicente.mongo.recipes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class RecipesApplication implements CommandLineRunner {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(RecipesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Clean up any existing data
        recipeRepository.deleteAll();
        userRepository.deleteAll();

        // Insert sample users
        User user1 = new User();
        user1.setUsername("john_doe");
        user1.setEmail("john@example.com");

        User user2 = new User();
        user2.setUsername("jane_doe");
        user2.setEmail("jane@example.com");

        User user3 = new User();
        user3.setUsername("alice");
        user3.setEmail("alice@example.com");

        User user4 = new User();
        user4.setUsername("bob");
        user4.setEmail("bob@example.com");

        User user5 = new User();
        user5.setUsername("charlie");
        user5.setEmail("charlie@example.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));

        // Insert sample recipes
        Recipe recipe1 = createSampleRecipe("Spaghetti Bolognese", user1);
        Recipe recipe2 = createSampleRecipe("Chicken Curry", user2);
        Recipe recipe3 = createSampleRecipe("Beef Stew", user3);
        Recipe recipe4 = createSampleRecipe("Vegetable Stir Fry", user4);
        Recipe recipe5 = createSampleRecipe("Fish Tacos", user5);

        recipeRepository.saveAll(Arrays.asList(recipe1, recipe2, recipe3, recipe4, recipe5));
    }

    private Recipe createSampleRecipe(String title, User author) {
        Recipe recipe = new Recipe();
        recipe.setTitle(title);
        recipe.setAuthor(author);
        recipe.setCreatedAt(new Date());

        switch (title) {
            case "Spaghetti Bolognese":
                recipe.setIngredients(Arrays.asList(
                        new Ingredient("Spaghetti", "200g"),
                        new Ingredient("Ground Beef", "400g"),
                        new Ingredient("Onion", "1, chopped"),
                        new Ingredient("Garlic", "2 cloves, minced"),
                        new Ingredient("Tomato Sauce", "400ml"),
                        new Ingredient("Olive Oil", "2 tbsp"),
                        new Ingredient("Salt", "to taste"),
                        new Ingredient("Pepper", "to taste"),
                        new Ingredient("Parmesan Cheese", "to serve")
                ));
                recipe.setSteps(Arrays.asList(
                        new Step(1, "Cook spaghetti according to package instructions."),
                        new Step(2, "Heat olive oil in a pan and sauté onion and garlic until softened."),
                        new Step(3, "Add ground beef and cook until browned."),
                        new Step(4, "Stir in tomato sauce, season with salt and pepper, and simmer for 15 minutes."),
                        new Step(5, "Serve sauce over spaghetti, topped with Parmesan cheese.")
                ));
                recipe.setTags(Arrays.asList("Pasta", "Italian", "Main Course"));
                break;

            case "Chicken Curry":
                recipe.setIngredients(Arrays.asList(
                        new Ingredient("Chicken Breast", "500g, diced"),
                        new Ingredient("Onion", "1, chopped"),
                        new Ingredient("Garlic", "3 cloves, minced"),
                        new Ingredient("Ginger", "1 inch, minced"),
                        new Ingredient("Tomatoes", "2, chopped"),
                        new Ingredient("Coconut Milk", "400ml"),
                        new Ingredient("Curry Powder", "2 tbsp"),
                        new Ingredient("Olive Oil", "2 tbsp"),
                        new Ingredient("Salt", "to taste"),
                        new Ingredient("Pepper", "to taste"),
                        new Ingredient("Cilantro", "for garnish")
                ));
                recipe.setSteps(Arrays.asList(
                        new Step(1, "Heat olive oil in a pan and sauté onion, garlic, and ginger until softened."),
                        new Step(2, "Add chicken and cook until no longer pink."),
                        new Step(3, "Stir in tomatoes and curry powder, and cook for 5 minutes."),
                        new Step(4, "Pour in coconut milk, season with salt and pepper, and simmer for 20 minutes."),
                        new Step(5, "Garnish with cilantro and serve.")
                ));
                recipe.setTags(Arrays.asList("Curry", "Indian", "Main Course"));
                break;

            case "Beef Stew":
                recipe.setIngredients(Arrays.asList(
                        new Ingredient("Beef Chuck", "1kg, cubed"),
                        new Ingredient("Carrots", "3, chopped"),
                        new Ingredient("Potatoes", "4, chopped"),
                        new Ingredient("Onion", "1, chopped"),
                        new Ingredient("Garlic", "2 cloves, minced"),
                        new Ingredient("Beef Broth", "1 liter"),
                        new Ingredient("Tomato Paste", "2 tbsp"),
                        new Ingredient("Olive Oil", "2 tbsp"),
                        new Ingredient("Salt", "to taste"),
                        new Ingredient("Pepper", "to taste"),
                        new Ingredient("Thyme", "1 tsp"),
                        new Ingredient("Bay Leaf", "1")
                ));
                recipe.setSteps(Arrays.asList(
                        new Step(1, "Heat olive oil in a large pot and brown the beef."),
                        new Step(2, "Remove the beef and sauté onion and garlic until softened."),
                        new Step(3, "Stir in tomato paste, then return beef to the pot."),
                        new Step(4, "Add carrots, potatoes, beef broth, thyme, and bay leaf."),
                        new Step(5, "Season with salt and pepper, bring to a boil, then simmer for 2 hours until beef is tender.")
                ));
                recipe.setTags(Arrays.asList("Stew", "Beef", "Main Course"));
                break;

            case "Vegetable Stir Fry":
                recipe.setIngredients(Arrays.asList(
                        new Ingredient("Broccoli", "1 head, chopped"),
                        new Ingredient("Carrots", "2, sliced"),
                        new Ingredient("Bell Pepper", "1, sliced"),
                        new Ingredient("Snow Peas", "100g"),
                        new Ingredient("Garlic", "2 cloves, minced"),
                        new Ingredient("Ginger", "1 inch, minced"),
                        new Ingredient("Soy Sauce", "3 tbsp"),
                        new Ingredient("Olive Oil", "2 tbsp"),
                        new Ingredient("Sesame Oil", "1 tsp"),
                        new Ingredient("Salt", "to taste"),
                        new Ingredient("Pepper", "to taste"),
                        new Ingredient("Sesame Seeds", "for garnish")
                ));
                recipe.setSteps(Arrays.asList(
                        new Step(1, "Heat olive oil in a wok and sauté garlic and ginger until fragrant."),
                        new Step(2, "Add broccoli, carrots, and bell pepper, and stir-fry for 5 minutes."),
                        new Step(3, "Add snow peas and soy sauce, and cook for another 3 minutes."),
                        new Step(4, "Drizzle with sesame oil, season with salt and pepper, and toss to combine."),
                        new Step(5, "Garnish with sesame seeds and serve.")
                ));
                recipe.setTags(Arrays.asList("Vegetarian", "Stir Fry", "Main Course"));
                break;

            case "Fish Tacos":
                recipe.setIngredients(Arrays.asList(
                        new Ingredient("White Fish Fillets", "500g"),
                        new Ingredient("Cabbage", "2 cups, shredded"),
                        new Ingredient("Lime", "1, juiced"),
                        new Ingredient("Sour Cream", "1/2 cup"),
                        new Ingredient("Mayonnaise", "1/4 cup"),
                        new Ingredient("Corn Tortillas", "8"),
                        new Ingredient("Olive Oil", "2 tbsp"),
                        new Ingredient("Cumin", "1 tsp"),
                        new Ingredient("Chili Powder", "1 tsp"),
                        new Ingredient("Salt", "to taste"),
                        new Ingredient("Pepper", "to taste"),
                        new Ingredient("Cilantro", "for garnish")
                ));
                recipe.setSteps(Arrays.asList(
                        new Step(1, "Mix sour cream, mayonnaise, and lime juice in a bowl."),
                        new Step(2, "Season fish with cumin, chili powder, salt, and pepper."),
                        new Step(3, "Heat olive oil in a pan and cook fish until opaque and flaky."),
                        new Step(4, "Warm tortillas in a dry skillet or microwave."),
                        new Step(5, "Assemble tacos with fish, cabbage, and a drizzle of the lime sauce. Garnish with cilantro and serve.")
                ));
                recipe.setTags(Arrays.asList("Tacos", "Fish", "Mexican", "Main Course"));
                break;

            default:
                throw new IllegalArgumentException("Unknown recipe title: " + title);
        }

        return recipe;
    }
}
