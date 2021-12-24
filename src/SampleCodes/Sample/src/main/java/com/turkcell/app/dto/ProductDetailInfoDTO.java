package com.turkcell.app.dto;

import com.turkcell.app.entity.ProductInfo;

import java.math.BigDecimal;

public class ProductDetailInfoDTO {
    public ProductInfo productInfo;
    public BigDecimal result;

    public ProductDetailInfoDTO(ProductInfo productInfo, BigDecimal result)
    {
        this.productInfo = productInfo;
        this.result = result;
    }

    @Override
    public String toString()
    {
        return String.format("%s Status: %s", productInfo, result);
    }
}
