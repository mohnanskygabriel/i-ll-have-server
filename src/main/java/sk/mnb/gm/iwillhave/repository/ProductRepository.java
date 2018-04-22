package sk.mnb.gm.iwillhave.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import sk.mnb.gm.iwillhave.domain.Product;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Optional<Set<Product>> findByCategoryId(Long categoryId);
}
