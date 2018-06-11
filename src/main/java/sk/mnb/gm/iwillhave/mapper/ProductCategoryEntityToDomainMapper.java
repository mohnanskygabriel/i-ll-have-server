package sk.mnb.gm.iwillhave.mapper;

import org.springframework.stereotype.Component;
import sk.mnb.gm.iwillhave.domain.ProductCategory;
import sk.mnb.gm.iwillhave.entity.ProductCategoryEntity;

import java.util.function.Function;

@Component
public class ProductCategoryEntityToDomainMapper implements Function<ProductCategoryEntity, ProductCategory> {


    @Override
    public ProductCategory apply(ProductCategoryEntity productCategoryEntity) {
        return ProductCategory.builder().
                id(productCategoryEntity.id()).
                category(productCategoryEntity.category()).build();
    }
}
