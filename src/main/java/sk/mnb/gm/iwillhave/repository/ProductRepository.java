package sk.mnb.gm.iwillhave.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import sk.mnb.gm.iwillhave.domain.Product;

import java.util.List;

@Component
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();


}
