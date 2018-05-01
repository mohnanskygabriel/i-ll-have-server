package sk.mnb.gm.iwillhave.repository;

import org.springframework.data.repository.CrudRepository;
import sk.mnb.gm.iwillhave.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {

    Optional<List<Order>> findByRestaurantTable(Long restaurantTable);

    Iterable<Order> findAll();

    Optional<List<Order>> findByPayed(boolean payed);

    Optional<List<Order>> findByPayedAndRestaurantTable(boolean payed, Long restaurantTable);


}
