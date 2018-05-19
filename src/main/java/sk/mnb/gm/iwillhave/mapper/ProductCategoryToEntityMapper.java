package sk.mnb.gm.iwillhave.mapper;

import org.springframework.stereotype.Component;
import sk.mnb.gm.iwillhave.domain.ProductCategory;
import sk.mnb.gm.iwillhave.entity.ProductCategoryEntity;

import java.util.function.Function;

@Component
public class ProductCategoryToEntityMapper implements Function<ProductCategory, ProductCategoryEntity> {


    @Override
    public ProductCategoryEntity apply(ProductCategory productCategory) {
        return ProductCategoryEntity.builder().category(productCategory.category()).build();
    }
}
