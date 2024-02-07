package com.example.recipe;

import com.example.recipe.RecipeRepository;
import com.example.recipe.Recipe;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

// Don't modify the below code

public class RecipeService implements RecipeRepository {

        private static HashMap<Integer, Recipe> recipeBook = new HashMap<>();

        public RecipeService() {
                recipeBook.put(1,
                                new Recipe(1, "Pasta", "veg",
                                                Arrays.asList("pasta", "tomatoes", "olive oil", "garlic", "basil")));
                recipeBook.put(2, new Recipe(2, "Chicken Curry", "non-veg",
                                Arrays.asList("chicken", "onion", "tomato", "ginger", "garlic", "spices")));
                recipeBook.put(3, new Recipe(3, "Sushi", "non-veg",
                                Arrays.asList("sushi rice", "tuna fish", "seaweed", "wasabi", "ginger")));
                recipeBook.put(4, new Recipe(4, "Mushroom Risotto", "veg",
                                Arrays.asList("rice", "mushrooms", "onion", "garlic", "butter", "parmesan")));
                recipeBook.put(5, new Recipe(5, "Fish and Chips", "non-veg",
                                Arrays.asList("fish", "potatoes", "flour", "oil", "spices")));
        }

        // Don't modify the above code

        // Write your code here
        int uniqueid = 6;

        @Override
        public ArrayList<Recipe> getAll() {

                Collection<Recipe> c = recipeBook.values();
                ArrayList<Recipe> arr = new ArrayList<>(c);
                return arr;
        }

        @Override
        public Recipe addRecipe(Recipe recipe) {
                recipe.setRecipeId(uniqueid);
                recipeBook.put(uniqueid, recipe);
                uniqueid += 1;
                return recipe;

        }

        @Override
        public Recipe getbyid(int recipeId) {
                Recipe r = recipeBook.get(recipeId);
                if (r == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

                }
                return r;
        }

        @Override
        public Recipe updaterecipe(int recipeId, Recipe recipe) {
                Recipe exist = recipeBook.get(recipeId);
                if (exist == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

                }
                if (recipe.getRecipeName() != null) {
                        exist.setRecipeName(recipe.getRecipeName());
                }
                if (recipe.getRecipeType() != null) {
                        exist.setRecipeType(recipe.getRecipeType());
                }
                if (recipe.getIngridients() != null) {
                        exist.setIngridients(recipe.getIngridients());
                }
                return exist;
        }

        @Override
        public void deleteRecipe(int recipeId) {
                Recipe re = recipeBook.get(recipeId);
                if (re == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                } else {
                        recipeBook.remove(recipeId);
                        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
                }
        }

}