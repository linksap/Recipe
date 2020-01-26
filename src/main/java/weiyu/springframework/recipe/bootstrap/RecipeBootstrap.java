package weiyu.springframework.recipe.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import weiyu.springframework.recipe.donmain.*;
import weiyu.springframework.recipe.repositories.CategoryRepository;
import weiyu.springframework.recipe.repositories.RecipeRepository;
import weiyu.springframework.recipe.repositories.UnitOfMeasureRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private  final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>();
        Optional <UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByUom("Each");
        Optional <UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByUom("Tablespoon");
        Optional <UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByUom("Cup");
        Optional <UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByUom("Pinch");
        Optional <UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByUom("Ounce");
        Optional <UnitOfMeasure> bowlUomOptional = unitOfMeasureRepository.findByUom("Bowl");
        Optional <UnitOfMeasure> coneUomOptional = unitOfMeasureRepository.findByUom("Cone");
        Optional <UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByUom("Teaspoon");
        UnitOfMeasure each = eachUomOptional.get();
        UnitOfMeasure tablespoon = tableSpoonUomOptional.get();
        UnitOfMeasure cup = cupUomOptional.get();
        UnitOfMeasure  pinch = pinchUomOptional.get();
        UnitOfMeasure once = ounceUomOptional.get();
        UnitOfMeasure bowl = bowlUomOptional.get();
        UnitOfMeasure cone  = coneUomOptional.get();
        UnitOfMeasure teaspoon = teaspoonUomOptional.get();

        Optional<Category> AmericanCategoryOptional = categoryRepository.findByDescription("American");
        Optional<Category> MexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        Optional<Category> ChineseCategoryOptional = categoryRepository.findByDescription("Chinese");

        Category American = AmericanCategoryOptional.get();
        Category Mexican = MexicanCategoryOptional.get();
        Category Chinese = ChineseCategoryOptional.get();

        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setDescription("How to Make Perfect Guacamole");
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setCookTime(0);
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        guacamoleRecipe.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl\n" +
                " Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");
        Note guacamoleNote = new Note();
        guacamoleNote.setRecipeNote("Simple Guacamole: The simplest version of guacamole is just mashed avocados with salt. Don’t let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "Quick guacamole: For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Don’t have enough avocados? To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.");
        guacamoleRecipe.setNotes(guacamoleNote);
        guacamoleNote.setRecipe(guacamoleRecipe);

        guacamoleRecipe.getIngredients().add(new Ingredient("ripe avocados",new BigDecimal(2),each,guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("salt",new BigDecimal(1/4),teaspoon,guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("fresh lime",new BigDecimal(1),tablespoon,guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("serrano chiles",new BigDecimal(2),each,guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("cilantro",new BigDecimal(2),tablespoon,guacamoleRecipe));
        guacamoleRecipe.getIngredients().add(new Ingredient("ripe tomato",new BigDecimal(1/2),each,guacamoleRecipe));
        guacamoleRecipe.getCategories().add(Mexican);
        guacamoleRecipe.getCategories().add(American);
        recipes.add(guacamoleRecipe);

        Recipe shrimpFriedRice = new Recipe();
        shrimpFriedRice.setDescription("Classic Shrimp Fried Rice with fresh shrimp, rice, green onions, peas, carrots, and sesame oil.");
        shrimpFriedRice.setPrepTime(5);
        shrimpFriedRice.setCookTime(10);
        shrimpFriedRice.setDifficulty(Difficulty.MODERATE);
        shrimpFriedRice.setDirections("1 Toss shrimp with salt, pepper, cornstarch: In a medium bowl, sprinkle the shrimp with salt, pepper, and cornstarch, and toss to coat. Set aside to sit for ten minutes at room temperature.\n" +
                "2 Heat pan on high heat: Heat a large sauté pan or wok (a seasoned cast iron pan or hard anodized aluminum works well, they're relatively stick free and can take the heat) on high heat.\n" +
                "3 Sear shrimp on both sides: Add the shrimp to the hot pan, spreading them out quickly in a single layer. Let them fry in the pan without moving them, for 30 seconds\n" +
                "4 Cook beaten eggs, slightly runny: Return the pan to the burner and lower the heat to medium. Add a little more oil if the pan needs it. Add the beaten eggs and stir them quickly to scramble them while they cook.\n" +
                "5 Sauté green onions, add rice: Clean out the pan or wok with paper towels and return it to the burner. Heat the pan on high and when it is hot, swirl in the remaining tablespoon or two of oil. When the oil is shimmering hot (almost smoking), add the green onions and sauté for 15 seconds.\n" +
                "6 Add soy sauce, carrots, peas, shrimp, eggs, sesame oil: Sprinkle soy sauce on the rice and stir to combine.\n" +
                "\n" +
                "Add the carrots, peas, shrimp, eggs, and sesame oil, stirring to combine well.");
        Note shrimpFiredRiceNote = new Note();
        shrimpFiredRiceNote.setRecipeNote("1. As mentioned, use chilled leftover rice! The dry refrigerator air helps dry the rice a bit, which is why cold leftover rice never tastes as good the next day if you eat it straight, but it’s perfect for frying.\n" +
                "\n" +
                "2. Use high heat. You don’t need a blazing hot restaurant kitchen stove, just patience to let your pan get hot. A hot pan will help everything fry quickly and help keep ingredients from sticking.\n" +
                "\n" +
                "3. Fry ingredients separately. To keep the ingredients and their flavors from mushing together, cook them separately, yet in the same pan. Start with the protein (in this case the shrimp), cook it until it’s almost done, then remove from the pan, and start cooking the other ingredients—the eggs next, then the rice. Add the protein and eggs back to the rice at the end.\n" +
                "\n" +
                "4. Minimize stirring. If you want browning, don’t stir. Just spread the rice out in the pan and let the pan do the work.");
        shrimpFriedRice.setNotes(shrimpFiredRiceNote);
        shrimpFiredRiceNote.setRecipe(shrimpFriedRice);
        shrimpFriedRice.getIngredients().add(new Ingredient("raw shrimp",new BigDecimal(8),once,shrimpFriedRice));
        shrimpFriedRice.getIngredients().add(new Ingredient("salt",new BigDecimal(8),teaspoon,shrimpFriedRice));
        shrimpFriedRice.getIngredients().add(new Ingredient("oil",new BigDecimal(3),tablespoon,shrimpFriedRice));
        shrimpFriedRice.getIngredients().add(new Ingredient("eggs",new BigDecimal(3),each,shrimpFriedRice));
        shrimpFriedRice.getIngredients().add(new Ingredient("Leftover rice",new BigDecimal(4),cup,shrimpFriedRice));

        shrimpFriedRice.getCategories().add(American);
        shrimpFriedRice.getCategories().add(Chinese);

        recipes.add(shrimpFriedRice);




        return recipes;
    }
}
