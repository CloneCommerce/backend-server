package com.commerce.backendserver.product.domain.promotion.discount;

import com.commerce.backendserver.global.exception.CommerceException;
import com.commerce.backendserver.product.domain.ProductPriceAttribute;

import static com.commerce.backendserver.product.exception.ProductError.INVALID_PROMOTION;

public class FixDiscountCalculator implements PromotionPriceCalculator {

    @Override
    public Integer getPromotionDiscountedAmount(
            ProductPriceAttribute attribute
    ) {
        validatePromotion(attribute);
        return attribute.getPromotion().getPromotionValue();
    }

    private void validatePromotion(
            ProductPriceAttribute attribute
    ) {
        if (attribute.getPromotion().getPromotionValue() < 0) {
            throw CommerceException.of(INVALID_PROMOTION);
        }
    }
}
