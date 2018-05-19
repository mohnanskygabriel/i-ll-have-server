package sk.mnb.gm.iwillhave.repository;

import org.springframework.data.repository.CrudRepository;
import sk.mnb.gm.iwillhave.domain.Order;
import sk.mnb.gm.iwillhave.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

    Optional<List<OrderEntity>> findByRestaurantTable(Long restaurantTable);

    Iterable<OrderEntity> findAll();

    Optional<List<OrderEntity>> findByPayed(boolean payed);

    Optional<List<OrderEntity>> findByPayedAndRestaurantTable(boolean payed, Long restaurantTable);


}
