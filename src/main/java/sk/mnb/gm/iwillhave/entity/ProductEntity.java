package sk.mnb.gm.iwillhave.entity;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.Wither;

import javax.persistence.*;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Value
@Accessors(fluent = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
@JsonAutoDetect(fieldVisibility = ANY)
@JsonInclude(NON_NULL)
@Entity(name = "Product")
public class ProductEntity {

    @Wither
    @Id
    @SequenceGenerator(name = "pk_product_sequence", sequenceName = "product_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pk_product_sequence")
    Long id;

    String name;

    @OneToOne(cascade = CascadeType.MERGE)
    ProductCategoryEntity category;

    double price;

}

