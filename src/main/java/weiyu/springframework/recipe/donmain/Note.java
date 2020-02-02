package weiyu.springframework.recipe.donmain;

import lombok.*;

import javax.persistence.*;


@Data
@EqualsAndHashCode (exclude = {"recipe"})
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNote;

    public Note() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Note;
    }

}
