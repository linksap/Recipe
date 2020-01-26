package weiyu.springframework.recipe.Services;

import weiyu.springframework.recipe.donmain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
