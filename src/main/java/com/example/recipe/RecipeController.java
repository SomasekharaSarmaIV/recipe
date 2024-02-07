/*
 * 
 * You can use the following import statements
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.recipe;

import com.example.recipe.RecipeService;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class RecipeController {
    RecipeService rs = new RecipeService();

    @GetMapping("/recipe")
    public ArrayList<Recipe> getAll() {
        return rs.getAll();
    }

    @PostMapping("/recipe")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return rs.addRecipe(recipe);
    }

    @GetMapping("/recipe/{id}")
    public Recipe getbyid(@PathVariable("id") int id) {
        return rs.getbyid(id);
    }

    @PutMapping("/recipe/{id}")
    public Recipe updaterecipe(@PathVariable("id") int id, @RequestBody Recipe recipe) {
        return rs.updaterecipe(id, recipe);
    }

    @DeleteMapping("/recipe/{id}")
    public void deleteRecipe(@PathVariable("id") int id) {
        rs.deleteRecipe(id);
    }
}