package com.commerce.backendserver.product.domain.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
public enum ProductSize {

    EXTRA_SMALL(85, "XS"),
    SMALL(90, "S"),
    MEDIUM(95, "M"),
    LARGE(100, "L"),
    EXTRA_LARGE(105, "XL"),
    TWO_EXTRA_LARGE(110, "2XL");

    private Integer numberSize;
    private String stringSize;
}
