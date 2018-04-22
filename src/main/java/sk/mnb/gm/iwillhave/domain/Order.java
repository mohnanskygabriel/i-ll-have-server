package sk.mnb.gm.iwillhave.domain;

import lombok.*;
import lombok.experimental.Wither;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "restaurant_order")
public class Order {

    @Id
    @Wither
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "restaurant_table")
    Long table;

    @CreatedDate
    Timestamp createdDate;

    Timestamp payedDate;

    boolean payed;

    @ManyToMany
    @JoinTable(name = "order_product")
    List<Product> products;


}
