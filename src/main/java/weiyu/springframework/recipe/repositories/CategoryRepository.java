package weiyu.springframework.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import weiyu.springframework.recipe.donmain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category , Long> {

    Optional<Category> findByDescription(String description);

}
