package com.neutroware.ebaysyncserver.shopify.api.mutation.productupdate;


import com.neutroware.ebaysyncserver.shopify.api.mutation.productcreate.ProductCreateArgs;

import java.util.List;

public record ProductUpdateArgs(
        ProductUpdateInput product,
        List<ProductCreateArgs.Media> media
) {
    public record ProductUpdateInput(
            String id,
            List<String> tags
    ) {}
}
