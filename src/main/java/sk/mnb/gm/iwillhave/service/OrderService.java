package sk.mnb.gm.iwillhave.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.mnb.gm.iwillhave.domain.Order;
import sk.mnb.gm.iwillhave.repository.OrderRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {

    OrderRepository orderRepository;

    public Optional getOrdersByTable(Long tableId) {
        return orderRepository.findByRestaurantTable(tableId);
    }

    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional getNotPayedOrders() {
        return orderRepository.findByPayed(false);
    }

    public Optional getNotPayedOrdersByRestaurantTableId(Long restaurantTableId) {
        return orderRepository.findByPayedAndRestaurantTable(false, restaurantTableId);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }


}
