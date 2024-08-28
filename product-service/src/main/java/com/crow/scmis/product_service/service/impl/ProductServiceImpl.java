package com.crow.scmis.product_service.service.impl;

import com.crow.scmis.product_service.entity.Product;
import com.crow.scmis.product_service.repository.IProductRepository;
import com.crow.scmis.product_service.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;


    @Override
    public Product create(Product product) {
        product.setId(UUID.randomUUID().toString());
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
