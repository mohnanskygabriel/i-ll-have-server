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
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Builder(toBuilder = true)
@Accessors(fluent = true)
@JsonAutoDetect(fieldVisibility = ANY)
@JsonInclude(NON_NULL)
@Entity(name = "restaurantTable")
public class RestaurantTableEntity {

    @Id
    @Wither
    @SequenceGenerator(name = "pk_table_sequence", sequenceName = "restaurant_table_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pk_table_sequence")
    private Long id;
    private String name;
    private String password;

}
