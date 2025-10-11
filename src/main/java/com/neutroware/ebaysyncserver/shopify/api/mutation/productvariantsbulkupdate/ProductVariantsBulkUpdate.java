package com.neutroware.ebaysyncserver.shopify.api.mutation.productvariantsbulkupdate;

import com.neutroware.ebaysyncserver.shopify.api.util.service.GraphQlClientFactory;
import com.neutroware.ebaysyncserver.shopify.api.util.service.ThrottleService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductVariantsBulkUpdate {
    private final GraphQlClientFactory graphQlClientFactory;
    private final ThrottleService throttleService;

    public ProductVariantsBulkUpdateResponse updateVariant(String storeName, String token, ProductVariantsBulkUpdateArgs args) {
        HttpGraphQlClient client = graphQlClientFactory.create(storeName, token);

        //language=GraphQl
        String mutation = """
            mutation ($productId: ID!, $variants: [ProductVariantsBulkInput!]!) {
                productVariantsBulkUpdate(productId: $productId, variants: $variants) {
                    product {
                        id
                    }
                    productVariants {
                        id
                    }
                    userErrors {
                        field
                        message
                    }
                }
            }
        """;

        Mono<ProductVariantsBulkUpdateResponse> monoResponse = client.document(mutation)
                .variable("productId", args.productId())
                .variable("variants", args.variants())
                .execute()
                .map(gqlResponse -> {
                    if (!gqlResponse.isValid()) {
                        throw new RuntimeException("productVariantsBulkUpdate error: " + gqlResponse.toString());
                    }
                    throttleService.throttle(gqlResponse.getExtensions());
                    return gqlResponse.field("productVariantsBulkUpdate")
                            .toEntity(ProductVariantsBulkUpdateResponse.class);
                });

        return monoResponse.block();
    }
}
