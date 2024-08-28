package com.crow.scmis.product_service.service;

import com.crow.scmis.product_service.entity.Product;

import java.util.List;

public interface IProductService {
    public Product create(Product product);
    public List<Product> getAll();
}
