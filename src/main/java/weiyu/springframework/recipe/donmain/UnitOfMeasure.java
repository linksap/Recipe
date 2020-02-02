package weiyu.springframework.recipe.donmain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class UnitOfMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uom;

}
