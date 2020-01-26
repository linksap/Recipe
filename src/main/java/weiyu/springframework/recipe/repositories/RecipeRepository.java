package weiyu.springframework.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import weiyu.springframework.recipe.donmain.Recipe;

public interface RecipeRepository extends CrudRepository <Recipe, Long> {
}
