package sk.mnb.gm.iwillhave.mapper;

import org.springframework.stereotype.Component;
import sk.mnb.gm.iwillhave.domain.RestaurantTable;
import sk.mnb.gm.iwillhave.entity.RestaurantTableEntity;

import java.util.function.Function;

@Component
public class RestaurantTableToEntityMapper implements Function<RestaurantTable, RestaurantTableEntity> {

    @Override
    public RestaurantTableEntity apply(RestaurantTable restaurantTableEntity) {
        return RestaurantTableEntity.builder().
                id(restaurantTableEntity.id()).
                name(restaurantTableEntity.name()).
                password(restaurantTableEntity.password()).build();
    }
}
