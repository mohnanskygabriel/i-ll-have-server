package sk.mnb.gm.iwillhave.service;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sk.mnb.gm.iwillhave.domain.Product;
import sk.mnb.gm.iwillhave.repository.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

}
