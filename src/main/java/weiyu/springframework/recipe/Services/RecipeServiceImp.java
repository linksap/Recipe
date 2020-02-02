package weiyu.springframework.recipe.Services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import weiyu.springframework.recipe.donmain.Recipe;
import weiyu.springframework.recipe.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Set;
@Slf4j
@Service
public class RecipeServiceImp implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImp(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm having service");
        Set <Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
