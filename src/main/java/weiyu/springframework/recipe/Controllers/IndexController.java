package weiyu.springframework.recipe.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import weiyu.springframework.recipe.Services.RecipeService;
import weiyu.springframework.recipe.donmain.Category;
import weiyu.springframework.recipe.donmain.UnitOfMeasure;
import weiyu.springframework.recipe.repositories.CategoryRepository;
import weiyu.springframework.recipe.repositories.RecipeRepository;
import weiyu.springframework.recipe.repositories.UnitOfMeasureRepository;

import java.util.Optional;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model)

    {
        model.addAttribute("recipes",recipeService.getRecipes());
        return "index";
    }
}
