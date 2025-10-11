package com.neutroware.ebaysyncserver.shopify.api.mutation.productvariantsbulkupdate;

public record ProductVariantsBulkUpdateResponse(
    Product product,
    ProductVariant[] productVariants,
    UserError[] userErrors
) {
    public record Product(
        String id
    ) {}

    public record ProductVariant(
        String id
    ) {}

    public record UserError(
        String field,
        String message
    ) {}
}
