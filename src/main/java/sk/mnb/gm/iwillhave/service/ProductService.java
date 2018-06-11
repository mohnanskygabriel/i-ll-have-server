package sk.mnb.gm.iwillhave.service;


import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import sk.mnb.gm.iwillhave.domain.Product;
import sk.mnb.gm.iwillhave.mapper.ProductEntityToDomainMapper;
import sk.mnb.gm.iwillhave.mapper.ProductToEntityMapper;
import sk.mnb.gm.iwillhave.repository.ProductRepository;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Transactional
@AllArgsConstructor
public class ProductService {

    private ProductEntityToDomainMapper productEntityToDomainMapper;
    private ProductRepository productRepository;
    private ProductToEntityMapper productToEntityMapper;

    public List<Product> getAllProducts() {
        val productList = new LinkedList<Product>();
        productRepository.findAll().forEach(productEntity ->
                productList.addLast(productEntityToDomainMapper.apply(productEntity)));
        return productList;
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id).map(productEntity -> productEntityToDomainMapper.apply(productEntity));
    }

    public Optional<Stream<Product>> getProductByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId).map(productEntities ->
                productEntities.stream().map(productEntity -> productEntityToDomainMapper.apply(productEntity)));
    }

    public Product saveNewProduct(Product product) {
        return productEntityToDomainMapper.apply(productRepository.saveAndFlush(productToEntityMapper.apply(product)));
    }

}
