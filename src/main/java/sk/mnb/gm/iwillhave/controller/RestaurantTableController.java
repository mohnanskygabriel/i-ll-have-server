package sk.mnb.gm.iwillhave.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.mnb.gm.iwillhave.domain.RestaurantTable;
import sk.mnb.gm.iwillhave.service.RestaurantTableService;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@RestController
@RequestMapping(path = "/table")
@AllArgsConstructor
public class RestaurantTableController {

    RestaurantTableService restaurantTableService;

    @GetMapping(path = "{tableName}")
    public ResponseEntity getTableByName(@PathVariable String tableName) {
        return restaurantTableService.getByName(tableName).map(restaurantTable ->
                new ResponseEntity<>(restaurantTable, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/check")
    public ResponseEntity checkTablePassword(@RequestBody RestaurantTable table) {
        if (restaurantTableService.checkPassword(table.name(), table.password())) {
            return new ResponseEntity<>(TRUE, HttpStatus.OK);
        }
        return new ResponseEntity<>(FALSE, HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public List<String> getAllTableNames() {
        return restaurantTableService.getAllTableNames();
    }


}
