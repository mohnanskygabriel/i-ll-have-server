package sk.mnb.gm.iwillhave.service;


import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import sk.mnb.gm.iwillhave.domain.RestaurantTable;
import sk.mnb.gm.iwillhave.mapper.RestaurantTableEntityToDomainMapper;
import sk.mnb.gm.iwillhave.repository.RestaurantTableRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RestaurantTableService {
    private RestaurantTableEntityToDomainMapper restaurantTableEntityToDomainMapper;
    private RestaurantTableRepository restaurantTableRepository;

    public Optional<RestaurantTable> getByName(String name) {
        return restaurantTableRepository.findByName(name).map(restaurantTableEntity ->
                restaurantTableEntityToDomainMapper.apply(restaurantTableEntity));
    }

    public boolean checkPassword(String tableName, String password) {
        return restaurantTableRepository.findByName(tableName).
                map(restaurantTableEntity -> restaurantTableEntity.password().equals(password)).orElse(false);
    }

    public List<String> getAllTableNames() {
        val tableNames = new LinkedList<String>();
        restaurantTableRepository.findAll().forEach(restaurantTable ->
                tableNames.addLast(restaurantTableEntityToDomainMapper.apply(restaurantTable).name()));
        return tableNames;
    }


}
