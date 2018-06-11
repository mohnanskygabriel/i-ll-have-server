package sk.mnb.gm.iwillhave.mapper;

import org.springframework.stereotype.Component;
import sk.mnb.gm.iwillhave.domain.Product;
import sk.mnb.gm.iwillhave.entity.ProductEntity;

import java.util.function.Function;

@Component
public class ProductToEntityMapper implements Function<Product, ProductEntity> {

    private ProductCategoryToEntityMapper productCategoryToEntityMapper = new ProductCategoryToEntityMapper();


    @Override
    public ProductEntity apply(Product product) {
        return ProductEntity.builder().
                id(product.id()).
                name(product.name()).
                category(productCategoryToEntityMapper.apply(product.category())).
                price(product.price()).
                build();
    }
}
