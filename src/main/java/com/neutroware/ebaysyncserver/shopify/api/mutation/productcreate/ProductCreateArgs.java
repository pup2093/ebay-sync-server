package com.neutroware.ebaysyncserver.shopify.api.mutation.productcreate;

import java.util.List;

public record ProductCreateArgs(
        ProductCreateInput product,
        List<Media> media
) {
    public record ProductCreateInput(
            String descriptionHtml,
            List<String> tags,
            String title
    ) {}

    public record Media(
            String alt,
            String mediaContentType,
            String originalSource
    ) {}
}
