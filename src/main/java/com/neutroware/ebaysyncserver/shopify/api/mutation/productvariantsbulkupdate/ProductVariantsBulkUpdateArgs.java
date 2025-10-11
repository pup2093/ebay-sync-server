package com.neutroware.ebaysyncserver.shopify.api.mutation.productvariantsbulkupdate;

public record ProductVariantsBulkUpdateArgs(
        String productId,
        ProductVariantsBulkInput[] variants
) {
    public record ProductVariantsBulkInput(
           String id,
           String price,
           InventoryItem inventoryItem
    ) {}

    public record InventoryItem(
            Measurement measurement,
            Boolean tracked,
            Boolean requiresShipping
    ) {}

    public record Measurement(
            Weight weight
    ) {}

    public record Weight(
            String unit,
            Float value
    ) {}
}