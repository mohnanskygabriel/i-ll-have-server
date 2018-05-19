package sk.mnb.gm.iwillhave.mapper;

import org.springframework.stereotype.Component;
import sk.mnb.gm.iwillhave.domain.RestaurantTable;
import sk.mnb.gm.iwillhave.entity.RestaurantTableEntity;

import java.util.function.Function;

@Component
public class RestaurantTableEntityToDomainMapper implements Function<RestaurantTableEntity, RestaurantTable> {

    @Override
    public RestaurantTable apply(RestaurantTableEntity restaurantTableEntity) {
        return RestaurantTable.builder().
                id(restaurantTableEntity.id()).
                name(restaurantTableEntity.name()).
                password(restaurantTableEntity.password()).build();
    }
}
