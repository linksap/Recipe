package weiyu.springframework.recipe.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import weiyu.springframework.recipe.donmain.UnitOfMeasure;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepositoryTest {
    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;
    @BeforeEach
    void setUp() {
    }

    @Test
    void findByUom() {
        Optional<UnitOfMeasure> unitOfMeasures = unitOfMeasureRepository.findByUom("Cup");
        assertEquals("Cup",unitOfMeasures.get().getUom());
    }
}