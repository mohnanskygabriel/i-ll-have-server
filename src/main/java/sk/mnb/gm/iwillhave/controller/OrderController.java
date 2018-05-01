package sk.mnb.gm.iwillhave.controller;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.mnb.gm.iwillhave.domain.Order;
import sk.mnb.gm.iwillhave.service.OrderService;
import sk.mnb.gm.iwillhave.service.RestaurantTableService;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/order")
public class OrderController {

    private OrderService orderService;
    private RestaurantTableService restaurantTableService;

    @GetMapping(path = "/table/{tableId}")
    public ResponseEntity getOrdersByRestaurantTable(@PathVariable Long tableId) {
        val responseOptional = orderService.getOrdersByTable(tableId);
        if (responseOptional.isPresent()) {
            return new ResponseEntity<>(responseOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/all")
    public ResponseEntity getAllOrders() {
        val allOrders = new ArrayList<>();
        orderService.getAllOrders().forEach(allOrders::add);
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }

    @GetMapping(path = "/notpayed")
    public ResponseEntity getNotPayedOrders() {
        val notPayedOrders = orderService.getNotPayedOrders();
        if (notPayedOrders.isPresent()) {
            return new ResponseEntity<>(notPayedOrders.get(), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/table/{tableId}/notpayed")
    public ResponseEntity getNotPayedOrdersByRestaurantTable(@PathVariable Long tableId) {
        val responseOptional = orderService.getNotPayedOrdersByRestaurantTableId(tableId);
        if (responseOptional.isPresent()) {
            return new ResponseEntity<>(responseOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity createOrder(@RequestBody Order order) {
        if (restaurantTableService.checkPassword(order.restaurantTable(), "a1")) {
            return new ResponseEntity<>(orderService.save(order), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }


}
