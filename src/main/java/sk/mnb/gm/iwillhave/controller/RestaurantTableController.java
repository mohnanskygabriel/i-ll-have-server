package sk.mnb.gm.iwillhave.controller;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.mnb.gm.iwillhave.service.RestaurantTableService;

@RestController
@RequestMapping(path = "/table")
@AllArgsConstructor
public class RestaurantTableController {

    RestaurantTableService restaurantTableService;

    @GetMapping(path = "{name}")
    public ResponseEntity getByName(@PathVariable String name) {
        val optional = restaurantTableService.getByName(name);
        if (optional.isPresent()) {
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/all")
    public ResponseEntity getAllTableNames() {
        return new ResponseEntity(restaurantTableService.getAllTableNames(), HttpStatus.OK);
    }


}
