package sk.mnb.gm.iwillhave.service;


import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import sk.mnb.gm.iwillhave.repository.RestaurantTableRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RestaurantTableService {

    RestaurantTableRepository restaurantTableRepository;

    public Optional getByName(String name) {
        return restaurantTableRepository.findByName(name);
    }

    public boolean checkPassword(Long tableId, String password) {
        return restaurantTableRepository.findById(tableId).map(restaurantTable ->
                restaurantTable.password().equals(password)).
                orElse(false);
    }

    public List getAllTableNames() {
        val tableNames = new LinkedList<String>();
        restaurantTableRepository.findAll().forEach(restaurantTable -> tableNames.addLast(restaurantTable.name()));
        return tableNames;
    }


}
