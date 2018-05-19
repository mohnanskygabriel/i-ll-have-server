package sk.mnb.gm.iwillhave.mapper;

import org.springframework.stereotype.Component;
import sk.mnb.gm.iwillhave.domain.Product;
import sk.mnb.gm.iwillhave.entity.ProductEntity;

import java.util.function.Function;

@Component
public class ProductEntityToDomainMapper implements Function<ProductEntity, Product> {

    @Override
    public Product apply(ProductEntity productEntity) {
        ProductCategoryEntityToDomainMapper productCategoryEntityToDomainMapper = new ProductCategoryEntityToDomainMapper();
        return Product.builder().
                id(productEntity.id()).
                name(productEntity.name()).
                price(productEntity.price()).
                category(productCategoryEntityToDomainMapper.apply(productEntity.category())).
                build();

    }
}
