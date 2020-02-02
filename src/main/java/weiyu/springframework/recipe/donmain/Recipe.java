package weiyu.springframework.recipe.donmain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String url;
    @Lob
    private String directions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();
    @Lob
    private Byte[] image;
    @OneToOne (cascade = CascadeType.ALL)
    private Note notes;
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    public Recipe() {
    }

    @ManyToMany
    @JoinTable(name = "Recipe_Category",joinColumns = @JoinColumn(name = "recipe_id"),inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

}
