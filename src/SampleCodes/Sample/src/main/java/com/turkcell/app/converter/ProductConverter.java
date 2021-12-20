package com.turkcell.app.converter;

import com.turkcell.app.entity.ProductInfo;
import com.turkcell.app.entity.ProductNameStockDTO;

public class ProductConverter {
    private final ProductInfo m_productInfo;

    public ProductConverter(ProductInfo productInfo)
    {
        m_productInfo = productInfo;
    }

    //...

    public ProductNameStockDTO toProductStockDTO()
    {
        return new ProductNameStockDTO(m_productInfo.getName(), m_productInfo.getStock());
    }
}
