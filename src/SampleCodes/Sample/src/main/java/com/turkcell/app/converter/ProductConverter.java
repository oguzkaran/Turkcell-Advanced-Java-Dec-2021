package com.turkcell.app.converter;

import com.turkcell.app.dto.ProductDetailInfoDTO;
import com.turkcell.app.entity.ProductInfo;
import com.turkcell.app.dto.ProductNameStockDTO;

import java.math.BigDecimal;

public class ProductConverter {
    private final ProductInfo m_productInfo;

    public ProductConverter(ProductInfo productInfo)
    {
        m_productInfo = productInfo;
    }

    //...

    public ProductDetailInfoDTO toProductDetailInfoDTO()
    {
        return new ProductDetailInfoDTO(m_productInfo, m_productInfo.getPrice().subtract(m_productInfo.getCost())
                .multiply(BigDecimal.valueOf(m_productInfo.getStock())));
    }

    public ProductNameStockDTO toProductStockDTO()
    {
        return new ProductNameStockDTO(m_productInfo.getName(), m_productInfo.getStock());
    }
}
