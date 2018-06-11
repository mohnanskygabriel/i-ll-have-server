package sk.mnb.gm.iwillhave.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.mnb.gm.iwillhave.domain.Order;
import sk.mnb.gm.iwillhave.service.OrderService;
import sk.mnb.gm.iwillhave.service.RestaurantTableService;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(path = "/order")
public class OrderController {

    private OrderService orderService;
    private RestaurantTableService restaurantTableService;

    @GetMapping(path = "/table/{tableId}")
    public ResponseEntity getOrdersByRestaurantTable(@PathVariable Long tableId) {
        return orderService.getOrdersByTable(tableId).map(orderStream ->
                new ResponseEntity<>(orderStream, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping(path = "/notpayed")
    public ResponseEntity getNotPayedOrders() {
        return orderService.getNotPayedOrders().map(orderStream ->
                new ResponseEntity<>(orderStream, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/table/{tableId}/notpayed")
    public ResponseEntity getNotPayedOrdersByRestaurantTable(@PathVariable Long tableId) {
        return orderService.getNotPayedOrdersByRestaurantTableId(tableId).map(orderStream ->
                new ResponseEntity<>(orderStream, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/create")
    public ResponseEntity createOrder(@RequestBody Order order) {
        log.info("Product:" + order.product().get(0).name());
        if (restaurantTableService.checkPassword(order.restaurantTable().name(), order.restaurantTable().password())) {
            return new ResponseEntity<>(orderService.save(order), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

    }


}
