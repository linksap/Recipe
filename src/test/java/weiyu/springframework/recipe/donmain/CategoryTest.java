package weiyu.springframework.recipe.donmain;


import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    Category category =new Category();
   @Before
   public void sad(){
       System.out.println("test");
   }
    @Test
    void getId() throws Exception{
        Long val =4L;
        category.setId(val);
        assertEquals(val,4L);
    }

    @Test
    void getDescription() {
    }

    @Test
    void getRecipes() {
    }
}