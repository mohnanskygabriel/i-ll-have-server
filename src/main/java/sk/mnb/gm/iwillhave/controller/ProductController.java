package sk.mnb.gm.iwillhave.controller;


import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.mnb.gm.iwillhave.domain.Product;
import sk.mnb.gm.iwillhave.service.ProductService;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @GetMapping(path = "/all")
    private ResponseEntity getAllProducts() {

        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity getProductById(@PathVariable Long id) {
        val optional = productService.getProductById(id);
        if (optional.isPresent()) {
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/category/{categoryId}")
    private ResponseEntity getProductByCategory(@PathVariable Long categoryId) {
        val optional = productService.getProductByCategory(categoryId);
        if (optional.isPresent()) {
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    private ResponseEntity getProductByCategory(@RequestBody Product product) {
        return new ResponseEntity<>(productService.saveNewProduct(product), HttpStatus.OK);
    }

}
