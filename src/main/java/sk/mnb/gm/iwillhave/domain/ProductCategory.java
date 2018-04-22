package sk.mnb.gm.iwillhave.domain;


import lombok.*;
import lombok.experimental.Wither;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder(toBuilder = true)
@Entity
class ProductCategory {

    @Wither
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String category;

}
