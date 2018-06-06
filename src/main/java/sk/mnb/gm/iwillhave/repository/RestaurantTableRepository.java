package sk.mnb.gm.iwillhave.repository;

import org.springframework.data.repository.CrudRepository;
import sk.mnb.gm.iwillhave.entity.RestaurantTableEntity;

import java.util.Optional;

public interface RestaurantTableRepository extends CrudRepository<RestaurantTableEntity, Long> {

    Optional<RestaurantTableEntity> findByName(String name);

}
