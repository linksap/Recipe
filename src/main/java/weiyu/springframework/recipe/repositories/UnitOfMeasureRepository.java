package weiyu.springframework.recipe.repositories;

import org.springframework.data.repository.CrudRepository;
import weiyu.springframework.recipe.donmain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    Optional <UnitOfMeasure> findByUom (String uom);


}
