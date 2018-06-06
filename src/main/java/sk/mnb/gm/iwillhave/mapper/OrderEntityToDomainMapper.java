package sk.mnb.gm.iwillhave.mapper;

import org.springframework.stereotype.Component;
import sk.mnb.gm.iwillhave.domain.Order;
import sk.mnb.gm.iwillhave.entity.OrderEntity;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class OrderEntityToDomainMapper implements Function<OrderEntity, Order> {


    private ProductEntityToDomainMapper productEntityToDomainMapper = new ProductEntityToDomainMapper();
    private RestaurantTableEntityToDomainMapper restaurantTableEntityToDomainMapper = new RestaurantTableEntityToDomainMapper();

    @Override
    public Order apply(OrderEntity orderEntity) {
        return Order.builder().
                id(orderEntity.id()).
                createdDate(orderEntity.createdDate()).
                payed(orderEntity.payed()).
                payedDate(orderEntity.payedDate()).
                restaurantTable(restaurantTableEntityToDomainMapper.apply(orderEntity.restaurantTable())).
                product(
                        orderEntity.product().stream().
                                map(productEntity -> productEntityToDomainMapper.apply(productEntity)).
                                collect(Collectors.toList())).build();
    }
}
