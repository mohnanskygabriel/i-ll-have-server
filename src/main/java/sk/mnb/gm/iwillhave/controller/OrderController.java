package sk.mnb.gm.iwillhave.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.mnb.gm.iwillhave.domain.Order;
import sk.mnb.gm.iwillhave.service.OrderService;
import sk.mnb.gm.iwillhave.service.RestaurantTableService;

import java.util.List;

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

   /* @PostMapping(path = "/create")
    public ResponseEntity createOrder(@RequestBody Order order) {
        if (restaurantTableService.checkPassword(order.restaurantTable(), "a1")) {
            return new ResponseEntity<>(orderService.save(order), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }*/


}
