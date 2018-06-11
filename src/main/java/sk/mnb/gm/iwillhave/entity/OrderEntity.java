package sk.mnb.gm.iwillhave.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.experimental.Wither;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity(name = "Order")
@Table(name = "restaurant_order")
@Value
@Accessors(fluent = true)
@NoArgsConstructor(access = PROTECTED, force = true)
@AllArgsConstructor(access = PRIVATE)
@Builder(toBuilder = true)
@JsonAutoDetect(fieldVisibility = ANY)
@JsonInclude(NON_NULL)
public class OrderEntity {

    @Id
    @Wither
    @SequenceGenerator(name = "pk_order_sequence", sequenceName = "restaurant_order_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pk_order_sequence")
    Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "restaurant_table")
    RestaurantTableEntity restaurantTable;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate;

    Timestamp payedDate;

    boolean payed;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "restaurant_order", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product", referencedColumnName = "id"))
    List<ProductEntity> product;


}
