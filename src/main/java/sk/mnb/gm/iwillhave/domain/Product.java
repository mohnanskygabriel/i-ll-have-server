package sk.mnb.gm.iwillhave.domain;


import lombok.*;
import lombok.experimental.Wither;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder(toBuilder = true)
@Entity
public class Product {

    @Wither
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    @OneToOne
    ProductCategory category;

    double price;

}
