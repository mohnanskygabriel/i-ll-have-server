package sk.mnb.gm.iwillhave.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.mnb.gm.iwillhave.service.ProductService;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @GetMapping()
    private ResponseEntity getAllProducts() {
        return productService.getAllProducts();
    }

}
