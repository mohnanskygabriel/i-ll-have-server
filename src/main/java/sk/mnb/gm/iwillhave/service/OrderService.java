package sk.mnb.gm.iwillhave.service;


import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import sk.mnb.gm.iwillhave.domain.Order;
import sk.mnb.gm.iwillhave.mapper.OrderEntityToDomainMapper;
import sk.mnb.gm.iwillhave.mapper.OrderToEntityMapper;
import sk.mnb.gm.iwillhave.repository.OrderRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {

    private OrderToEntityMapper orderToEntityMapper;
    private OrderEntityToDomainMapper orderEntityToDomainMapper;
    private OrderRepository orderRepository;

    public Optional<Stream<Order>> getOrdersByTable(Long tableId) {
        return orderRepository.findByRestaurantTable(tableId).map(orderEntities ->
                orderEntities.stream().map(orderEntity -> orderEntityToDomainMapper.apply(orderEntity)));
    }

    public List<Order> getAllOrders() {
        val listOfOrders = new LinkedList<Order>();
        orderRepository.findAll().forEach(
                orderEntity -> listOfOrders.addLast(orderEntityToDomainMapper.apply(orderEntity)));
        return listOfOrders;
    }

    public Optional<Stream<Order>> getNotPayedOrders() {
        return orderRepository.findByPayed(false).map(orderEntities ->
                orderEntities.stream().map(orderEntity -> orderEntityToDomainMapper.apply(orderEntity)));
    }

    public Optional<Stream<Order>> getNotPayedOrdersByRestaurantTableId(Long restaurantTableId) {
        return orderRepository.findByPayedAndRestaurantTable(false, restaurantTableId).map(orderEntities ->
                orderEntities.stream().map(orderEntity -> orderEntityToDomainMapper.apply(orderEntity)));
    }

    public Order save(Order order) {
        return orderEntityToDomainMapper.apply(orderRepository.save(orderToEntityMapper.apply(order)));
    }


}
