package sk.mnb.gm.iwillhave.mapper;

import org.springframework.stereotype.Component;
import sk.mnb.gm.iwillhave.domain.Order;
import sk.mnb.gm.iwillhave.entity.OrderEntity;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class OrderToEntityMapper implements Function<Order, OrderEntity> {


    private ProductToEntityMapper productToEntityMapper = new ProductToEntityMapper();
    private RestaurantTableToEntityMapper restaurantTableToEntityMapper = new RestaurantTableToEntityMapper();

    @Override
    public OrderEntity apply(Order order) {
        return OrderEntity.builder().
                id(order.id()).
                payed(order.payed()).
                payedDate(order.payedDate()).
                createdDate(order.createdDate()).
                product(
                        order.product().stream().
                                map(product -> productToEntityMapper.apply(product)).collect(Collectors.toList())).
                restaurantTable(restaurantTableToEntityMapper.apply(order.restaurantTable())).
                build();
    }
}
