package sk.mnb.gm.iwillhave.repository;

import org.springframework.data.repository.CrudRepository;
import sk.mnb.gm.iwillhave.domain.RestaurantTable;

import java.util.Optional;

public interface RestaurantTableRepository extends CrudRepository<RestaurantTable, Long> {

    Optional<RestaurantTable> findByName(String name);

}
