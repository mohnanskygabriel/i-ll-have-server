package sk.mnb.gm.iwillhave.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.mnb.gm.iwillhave.repository.RestaurantTableRepository;

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


}
