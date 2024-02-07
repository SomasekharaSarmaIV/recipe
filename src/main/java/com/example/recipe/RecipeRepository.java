// Write your code here
package com.example.recipe;

import java.util.*;

public interface RecipeRepository {
    public ArrayList<Recipe> getAll();

    public Recipe addRecipe(Recipe recipe);

    public Recipe getbyid(int recipeId);

    public Recipe updaterecipe(int recipeId, Recipe recipe);

    public void deleteRecipe(int recipeId);
}