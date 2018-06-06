package sk.mnb.gm.iwillhave.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import sk.mnb.gm.iwillhave.entity.ProductEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

    List<ProductEntity> findAll();

    Optional<ProductEntity> findById(Long id);

    Optional<Set<ProductEntity>> findByCategoryId(Long categoryId);
}
