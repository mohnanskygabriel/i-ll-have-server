package sk.mnb.gm.iwillhave.mapper;

import lombok.val;
import org.springframework.stereotype.Component;
import sk.mnb.gm.iwillhave.domain.Product;
import sk.mnb.gm.iwillhave.entity.ProductEntity;

import java.util.function.Function;

@Component
public class ProductToEntityMapper implements Function<Product, ProductEntity> {

    private ProductCategoryToEntityMapper productCategoryToEntityMapper = new ProductCategoryToEntityMapper();


    @Override
    public ProductEntity apply(Product product) {
        val category = product.category();
        val entity = ProductEntity.builder().
                id(product.id()).
                name(product.name()).
                price(product.price()).
                build();
        if (category == null) {
            return entity;
        }

        return entity.toBuilder().category(productCategoryToEntityMapper.apply(category)).build();

    }
}
