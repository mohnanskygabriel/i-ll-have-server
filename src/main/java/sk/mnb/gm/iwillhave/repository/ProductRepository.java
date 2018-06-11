package sk.mnb.gm.iwillhave.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.mnb.gm.iwillhave.entity.ProductEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAll();

    Optional<ProductEntity> findById(Long id);

    Optional<Set<ProductEntity>> findByCategoryId(Long categoryId);
}
