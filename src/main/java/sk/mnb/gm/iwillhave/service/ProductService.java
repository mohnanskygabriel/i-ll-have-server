package sk.mnb.gm.iwillhave.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.mnb.gm.iwillhave.domain.Product;
import sk.mnb.gm.iwillhave.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Optional getProductByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

}
