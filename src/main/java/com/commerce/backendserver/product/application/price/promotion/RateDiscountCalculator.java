package com.commerce.backendserver.product.application.price.promotion;

import com.commerce.backendserver.global.exception.CommerceException;
import com.commerce.backendserver.product.domain.promotion.Promotion;

import static com.commerce.backendserver.product.exception.ProductError.INVALID_PROMOTION;

public class RateDiscountCalculator implements PromotionPriceUtil {

    @Override
    public Integer getAppliedPromotionAmount(
            Integer originPrice,
            Promotion promotion
    ) {
        if (isInvalidPromotion(promotion)) {
            throw CommerceException.of(INVALID_PROMOTION);
        }
        return originPrice / 100 * promotion.getPromotionPriceAttribute().getDiscountAmount();
    }

    @Override
    public boolean isInvalidPromotion(Promotion promotion) {
        return promotion.getPromotionPriceAttribute().getDiscountAmount() <= 0 ||
                promotion.getPromotionPriceAttribute().getDiscountAmount() > 100;
    }
}
